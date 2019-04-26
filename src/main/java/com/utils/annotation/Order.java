package com.utils.annotation;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Order {
    @NotNull(message = "用户ID不能为空")
    private Long userID;
    @NotNull(message = "收货人地址id不能为空")
    private Long addressID;
    @NotBlank(message = "备注不为空")
    private String comment;

    public Order() {
    }
}