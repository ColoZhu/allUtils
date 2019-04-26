package com.utils.edi;




import org.milyn.edi.unedifact.d96a.D96AInterchangeFactory;
import org.milyn.smooks.edi.unedifact.model.UNEdifactInterchange;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactInterchange41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.utils.edi.PartinDTO.CustomerDto;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
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
            // D96AInterchangeFactory factory = D96AInterchangeFactory.getInstance();

            D96AInterchangeFactory factory = D96AInterchangeFactory.getInstance();
            stream = new FileInputStream(filePath);
            UNEdifactInterchange interchange;
            System.out.println("转换开始fromUNEdifact :");
            interchange = factory.fromUNEdifact(stream);
            System.out.println("转换成功fromUNEdifact :");


            if (interchange instanceof UNEdifactInterchange41) {
                UNEdifactInterchange41 interchange41 = (UNEdifactInterchange41) interchange;

                int a=1;
                System.out.println("interchange41 :" + interchange41);

                // 0. 打印报文（注：仅用于查看报文结构，最后要将其去除）
               /* JsonUtil jsonUtil = JsonUtilFactory.create(JsonUtilFactory.JsonUtilEnum.Jackson);
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
