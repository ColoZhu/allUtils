package com.utils.edi;

import java.util.List;

public class PartinDTO {

    /**
     * 仓别（库区：ZQ1）
     */
    private String locZone;
    /**
     * 头部日期（180110）
     */
    private String headDate;
    /**
     * 头部时间（0651）
     */
    private String headTime;
    /**
     * 头部中唯一流水识别码（0051674）
     */
    private String headId;

    private List<CustomerDto> customerDtoList;

    public String getLocZone() {
        return locZone;
    }

    public void setLocZone(String locZone) {
        this.locZone = locZone;
    }

    public String getHeadDate() {
        return headDate;
    }

    public void setHeadDate(String headDate) {
        this.headDate = headDate;
    }

    public String getHeadTime() {
        return headTime;
    }

    public void setHeadTime(String headTime) {
        this.headTime = headTime;
    }

    public String getHeadId() {
        return headId;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    public List<CustomerDto> getCustomerDtoList() {
        return customerDtoList;
    }

    public void setCustomerDtoList(List<CustomerDto> customerDtoList) {
        this.customerDtoList = customerDtoList;
    }

    public static class CustomerDto {
        private String supplierNo;      //商品编码
        private String address;         //地址
        private String nameCn;          //中文名称
        private String nameEn;          //英文名称
        private String tel;             //电话
        private String fax;             //传真

        public String getSupplierNo() {
            return supplierNo;
        }

        public void setSupplierNo(String supplierNo) {
            this.supplierNo = supplierNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNameCn() {
            return nameCn;
        }

        public void setNameCn(String nameCn) {
            this.nameCn = nameCn;
        }

        public String getNameEn() {
            return nameEn;
        }

        public void setNameEn(String nameEn) {
            this.nameEn = nameEn;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        @Override
        public String toString() {
            return "CustomerDto{" +
                    "supplierNo='" + supplierNo + '\'' +
                    ", address='" + address + '\'' +
                    ", nameCn='" + nameCn + '\'' +
                    ", nameEn='" + nameEn + '\'' +
                    ", tel='" + tel + '\'' +
                    ", fax='" + fax + '\'' +
                    '}';
        }
    }


}
