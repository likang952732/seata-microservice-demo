package com.example.seataproductservice.entity;

import lombok.Data;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 15:01   
 */
@Data
public class ProductReduceStockDTO {
    /**
     * 商品编号
     */
    private Long productId;
    /**
     * 数量
     */
    private Integer amount;
}
