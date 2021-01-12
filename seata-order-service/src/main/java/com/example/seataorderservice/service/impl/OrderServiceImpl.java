package com.example.seataorderservice.service.impl;

import com.example.seataorderservice.dao.OrderDao;
import com.example.seataorderservice.entity.OrderDO;
import com.example.seataorderservice.feign.AccountFeignService;
import com.example.seataorderservice.feign.StockFeignService;
import com.example.seataorderservice.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 14:19   
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StockFeignService stockFeignService;
    @Autowired
    private AccountFeignService accountFeignService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public Integer createOrder(Long userId, Long productId, Integer price) throws Exception {
        Integer amount = 1; // 购买数量，暂时设置为 1。
        log.info("[createOrder] 当前 XID: {}", RootContext.getXID());
        // 扣减库存
        Boolean resb = null;
        try {
            resb = stockFeignService.reduceStock(productId, amount);
            if(!resb){
                throw new RuntimeException("扣减库存失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("扣减库存失败");
        }
        // 扣减余额
        Boolean reb = null;
        try {
            reb = accountFeignService.reduceBalance(userId, price);
            if(!reb){
                throw new RuntimeException("扣减余额失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("扣减余额失败");
        }
        // 保存订单
        OrderDO order = new OrderDO();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setPayAmount(amount * price);
        orderDao.saveOrder(order);
        log.info("[createOrder] 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }
}
