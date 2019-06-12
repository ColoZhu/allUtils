package com.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    private Long type = 1 == 2 ? 7L : 8L;


    @Test
    public void test() {


        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<request> \n" +
                "  <operationFlag>WT</operationFlag>  \n" +
                "  <customerCode>CPTEST</customerCode>  \n" +
                "  <customerName/>  \n" +
                "  <projectCode>CPTESTBBB</projectCode>  \n" +
                "  <transportMode>LTL</transportMode>  \n" +
                "  <vehicleModel/>  \n" +
                "  <orderCode>BEST2018-8-17</orderCode>  \n" +
                "  <tradeMark/>  \n" +
                "  <totalAmount>21000</totalAmount>  \n" +
                "  <goodsValue>0.0</goodsValue>  \n" +
                "  <sender> \n" +
                "    <name>百世集团</name>  \n" +
                "    <province>浙江省</province>  \n" +
                "    <city>杭州市</city>  \n" +
                "    <district>西湖区</district>  \n" +
                "    <address>塘苗路18号</address>  \n" +
                "    <contactName>张三</contactName>  \n" +
                "    <phone>13112341234</phone>  \n" +
                "    <earlyPickupTime>2018-08-17 05:08:54</earlyPickupTime>  \n" +
                "    <latePickupTime>2018-08-17 13:08:54</latePickupTime> \n" +
                "  </sender>  \n" +
                "  <receiver> \n" +
                "    <name>BEST</name>  \n" +
                "    <province>上海</province>  \n" +
                "    <city>上海</city>  \n" +
                "    <district>普陀区</district>  \n" +
                "    <address>真北路2251号商务办公中心</address>  \n" +
                "    <contactName>小罗</contactName>  \n" +
                "    <phone>15212341234</phone>  \n" +
                "    <earlyDeliveryTime>2018-08-17 15:08:54</earlyDeliveryTime>  \n" +
                "    <lateDeliveryTime>2018-08-18 01:08:54</lateDeliveryTime> \n" +
                "  </receiver>  \n" +
                "  <referenceReqList> \n" +
                "    <referenceReq> \n" +
                "      <outorderType>RECEIPT_CODE</outorderType>  \n" +
                "      <outorderValue>12345</outorderValue> \n" +
                "    </referenceReq> \n" +
                "  </referenceReqList>  \n" +
                "  <serviceList> \n" +
                "    <service> \n" +
                "      <serviceDefinitionCode>DELIVERY</serviceDefinitionCode>  \n" +
                "      <serviceCodeList> \n" +
                "        <serviceCode> \n" +
                "          <serviceDefParameterCode/>  \n" +
                "          <actualValue/> \n" +
                "        </serviceCode> \n" +
                "      </serviceCodeList> \n" +
                "    </service> \n" +
                "  </serviceList>  \n" +
                "  <itemList> \n" +
                "    <item> \n" +
                "      <lineNo>1</lineNo>  \n" +
                "      <itemSkuCode>82212275.</itemSkuCode>  \n" +
                "      <itemName>牛奶</itemName>  \n" +
                "      <itemQuantity>2000</itemQuantity>  \n" +
                "      <packageCount>125</packageCount>  \n" +
                "      <weight>0.0</weight>  \n" +
                "      <volume>0.0000</volume>  \n" +
                "      <unitPrice>10.5</unitPrice>  \n" +
                "      <fixStatusCode>Y</fixStatusCode>  \n" +
                "      <uomCode>EA</uomCode>  \n" +
                "      <untiprice>0.0</untiprice> \n" +
                "    </item> \n" +
                "  </itemList>  \n" +
                "  <warehouseCode>EC_HZ_QS</warehouseCode>  \n" +
                "  <actionType>ADD</actionType>  \n" +
                "  <extTradeId>BEST2018-8-17</extTradeId>  \n" +
                "  <operationTypeCode>ASN</operationTypeCode>  \n" +
                "  <orderTime>2018-08-17 01:08:54</orderTime>  \n" +
                "  <udfFlag>true</udfFlag>  \n" +
                "  <udf1/>  \n" +
                "  <udf2/>  \n" +
                "  <shipmentTime/>  \n" +
                "  <shipmentFinishTime/>  \n" +
                "  <deliveryTime/>  \n" +
                "  <productCode/>  \n" +
                "  <remark>仓库打印</remark> \n" +
                "</request> \n" +
                "\n";
        str = str.replaceAll("> < ", "><")
                .replaceAll(">  <", "><")
                .replaceAll(">   <", "><")
                .replaceAll(">    <", "><")

         .replaceAll("\r|\n", "");
        ;
        System.out.println(str);
    }


}