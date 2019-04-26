package com.utils.edi;


import org.apache.commons.collections.CollectionUtils;
import org.milyn.edi.unedifact.d96a.D96AInterchangeFactory;
import org.milyn.edi.unedifact.d96a.PRICAT.Pricat;
import org.milyn.edi.unedifact.d96a.PRICAT.SegmentGroup16;
import org.milyn.edi.unedifact.d96a.PRICAT.SegmentGroup26;
import org.milyn.edi.unedifact.d96a.PRICAT.SegmentGroup33;
import org.milyn.edi.unedifact.d96a.common.*;
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
 * 解析商品报文：PARTIN
 */
public class PricatManager {

    protected static Logger logger = LoggerFactory.getLogger(PricatManager.class);

    /**
     * 读
     */
    public static void read(String filePath) {


        InputStream stream = null;

        try {
            D96AInterchangeFactory factory = D96AInterchangeFactory.getInstance();
            stream = new FileInputStream(filePath);
            UNEdifactInterchange interchange;
            interchange = factory.fromUNEdifact(stream);
            System.out.println("没有异常interchange :" + interchange);

            // factory.
            if (interchange instanceof UNEdifactInterchange41) {
                UNEdifactInterchange41 interchange41 = (UNEdifactInterchange41) interchange;
                // 0. 打印报文（注：仅用于查看报文结构，最后要将其去除）


            }
        } catch (Exception e) {
            logger.error("解析报文[pricat]出现了未知异常！！！", e);
        } finally {
            StreamUtil.close(stream, logger);
        }

        logger.info("[pricat]解析报文成功：" + filePath);

    }
}
