package com.example.seataaccountservice.service;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 14:49   
 */
public interface AccountService {
    /**
     * 扣除余额
     *
     * @param userId 用户编号
     * @param price  扣减金额
     * @throws Exception 失败时抛出异常
     */
    void reduceBalance(Long userId, Integer price) throws Exception;
}
