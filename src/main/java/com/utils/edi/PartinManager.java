package com.utils.edi;


import com.utils.edi.PartinDTO.CustomerDto;
import org.apache.commons.collections.CollectionUtils;
import org.milyn.edi.unedifact.d96a.D96AInterchangeFactory;
import org.milyn.edi.unedifact.d96a.PARTIN.Partin;
import org.milyn.edi.unedifact.d96a.PARTIN.SegmentGroup4;
import org.milyn.edi.unedifact.d96a.PARTIN.SegmentGroup7;
import org.milyn.edi.unedifact.d96a.common.COMCommunicationContact;
import org.milyn.edi.unedifact.d96a.common.NADNameAndAddress;
import org.milyn.edi.unedifact.d96a.common.field.C076CommunicationContact;
import org.milyn.smooks.edi.unedifact.model.UNEdifactInterchange;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactInterchange41;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactMessage41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析供应商报文：PARTIN
 */
public class PartinManager {

    protected static Logger logger = LoggerFactory.getLogger(PartinManager.class);

    /**
     * 读
     */
    public static PartinDTO read(String filePath) {

        PartinDTO dto = null;
        InputStream stream = null;

        try {
            D96AInterchangeFactory factory = D96AInterchangeFactory.getInstance();
            stream = new FileInputStream(filePath);
            UNEdifactInterchange interchange;
            interchange = factory.fromUNEdifact(stream);
            if (interchange instanceof UNEdifactInterchange41) {
                UNEdifactInterchange41 interchange41 = (UNEdifactInterchange41) interchange;

                // 0. 打印报文（注：仅用于查看报文结构，最后要将其去除）
             /*   JsonUtil jsonUtil = JsonUtilFactory.create(JsonUtilFactory.JsonUtilEnum.Jackson);
                logger.debug("下面是解析报文-----");
                logger.debug(jsonUtil.toJson(interchange41));*/

                // 1. 报文头
                dto = new PartinDTO();
                dto.setLocZone(interchange41.getInterchangeHeader().getRecipient().getId());
                dto.setHeadDate(interchange41.getInterchangeHeader().getDate().getDate());
                dto.setHeadTime(interchange41.getInterchangeHeader().getDate().getTime());
                dto.setHeadId(interchange41.getInterchangeHeader().getControlRef());

                // 2. 供应商列表
                List<CustomerDto> customerDtoList = new ArrayList<>();
                dto.setCustomerDtoList(customerDtoList);
                for (UNEdifactMessage41 messageWithControlSegments : interchange41.getMessages()) {

                    Object messageObj = messageWithControlSegments.getMessage();
                    if (messageObj instanceof Partin) {
                        Partin partin = (Partin) messageObj;

                        List<SegmentGroup4> segmentGroup4_cuList = partin.getSegmentGroup4(); //供应商的list
                        if (CollectionUtils.isNotEmpty(segmentGroup4_cuList)) {
                            for (SegmentGroup4 segment : segmentGroup4_cuList) {
                                CustomerDto item_cu = new CustomerDto();
                                if (segment != null) {
                                    //名称和地址
                                  //  NameAndAddress nameAndAddress = segment.getNameAndAddress();
                                    NADNameAndAddress nameAndAddress = segment.getNADNameAndAddress();
                                    if (nameAndAddress != null) {
                                     /*   if (nameAndAddress.getPartyIdentificationDetails() != null &&
                                                nameAndAddress.getPartyIdentificationDetails().getPartyIdIdentification() != null) {*/
                                        if (nameAndAddress.getC082PartyIdentificationDetails() != null &&
                                                nameAndAddress.getC082PartyIdentificationDetails().getE3039PartyIdIdentification() != null) {
                                            //item_cu.setSupplierNo(nameAndAddress.getPartyIdentificationDetails().getPartyIdIdentification()); //供应商编码
                                            item_cu.setSupplierNo(nameAndAddress.getC082PartyIdentificationDetails().getE3039PartyIdIdentification()); //供应商编码

                                        }
                                        if (nameAndAddress.getC058NameAndAddress() != null &&
                                                nameAndAddress.getC058NameAndAddress().getE31241NameAndAddressLine() != null) {
                                            item_cu.setAddress(nameAndAddress.getC058NameAndAddress().getE31241NameAndAddressLine()); //地址
                                        }
                                        if (nameAndAddress.getC080PartyName() != null) {
                                            item_cu.setNameCn(nameAndAddress.getC080PartyName().getE30362PartyName()); //中文名称
                                            item_cu.setNameEn(nameAndAddress.getC080PartyName().getE30361PartyName()); //英文名称
                                        }

                                    }

                                    List<SegmentGroup7> segmentGroup7List = segment.getSegmentGroup7();
                                    String fax = null;
                                    String tel = null;
                                    //传真和电话,各取一个
                                    if (CollectionUtils.isNotEmpty(segmentGroup7List)) {
                                        for (SegmentGroup7 item_segmentGroup7 : segmentGroup7List) {
                                            if (fax != null && tel != null) {
                                                break;  //如果已经有值直接退出
                                            }
                                            List<COMCommunicationContact> contactList = item_segmentGroup7.getCOMCommunicationContact();
                                            if (CollectionUtils.isNotEmpty(contactList)) {
                                                for (COMCommunicationContact item_contact : contactList) {
                                                    if (fax != null && tel != null) {
                                                        break;  //如果已经有值直接退出
                                                    }
                                                    C076CommunicationContact communicationContact = item_contact.getC076CommunicationContact();
                                                    if (communicationContact != null) {
                                                        String type = communicationContact.getE3155CommunicationChannelQualifier();
                                                        if (type != null) {
                                                            if (tel == null && type.equals("TE")) {
                                                                tel = communicationContact.getE3148CommunicationNumber(); //不存在就赋值
                                                            } else if (fax == null && type.equals("FX")) {
                                                                fax = communicationContact.getE3148CommunicationNumber(); //不存在就赋值
                                                            }
                                                        }
                                                    }

                                                }
                                            }

                                        }
                                        item_cu.setFax(fax); //传真
                                        item_cu.setTel(tel); //电话
                                    }
                                    customerDtoList.add(item_cu);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("解析报文[partin]出现了未知异常！！！", e);
        } finally {
            StreamUtil.close(stream, logger);
        }

        logger.info("[partin]解析报文成功：" + filePath);
        return dto;
    }
}
