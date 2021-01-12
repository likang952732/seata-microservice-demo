package com.example.seataproductservice.service;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 15:03   
 */
public interface ProductService {
    /**
     * 扣减库存
     *
     * @param productId 商品 ID
     * @param amount    扣减数量
     * @throws Exception 扣减失败时抛出异常
     */
    void reduceStock(Long productId, Integer amount) throws Exception;
}
