package com.example.seataorderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 15:10   
 */
@FeignClient("account-service")
public interface AccountFeignService {
    @PostMapping("/account/reduce-balance")
    Boolean reduceBalance(@RequestParam("userId")Long userId, @RequestParam("price")Integer price) throws Exception;
}
