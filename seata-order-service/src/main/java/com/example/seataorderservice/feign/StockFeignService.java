package com.example.seataorderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 14:30   
 */
@FeignClient("product-service")
public interface StockFeignService {
    @PostMapping("/product/reduce/stock")
    Boolean reduceStock(@RequestParam("productId")Long productId, @RequestParam("amount")Integer amount) throws Exception;
}
