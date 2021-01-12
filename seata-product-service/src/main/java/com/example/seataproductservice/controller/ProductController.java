package com.example.seataproductservice.controller;

import com.example.seataproductservice.entity.ProductReduceStockDTO;
import com.example.seataproductservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 @Description
 *@author kang.li
 *@date 2021/1/11 15:05   
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/reduce/stock")
    public Boolean reduceStock(ProductReduceStockDTO productReduceStockDTO) {
        log.info("[reduceStock] 收到减少库存请求, 商品:{}, 价格:{}", productReduceStockDTO.getProductId(),
                productReduceStockDTO.getAmount());
        try {
            productService.reduceStock(productReduceStockDTO.getProductId(), productReduceStockDTO.getAmount());
            return true;
        } catch (Exception e) {
            // 失败扣除库存，返回 false
            return false;
        }
    }
}
