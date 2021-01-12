package com.example.seataaccountservice.entity;

import lombok.Data;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 14:47   
 */
@Data
public class AccountReduceBalanceDTO {
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 扣减金额
     */
    private Integer price;
}
