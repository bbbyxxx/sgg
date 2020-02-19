package com.xzy.fruitmall.controller;

import com.xzy.fruitmall.biz.ShoppingService;
import com.xzy.fruitmall.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sgg")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;
    @GetMapping(value = "/shoppingCartDisplay/{customerId}")
    public String shoppingCartDisplay(@PathVariable("customerId") String customerId){
        return shoppingService.shoppingCartDisplay(customerId);
    }
    @GetMapping(value = "/addOrder/{customerId}/{orderAmount}/{addressId}")
    public boolean addOrder(OrderInfo oi){
        shoppingService.addOrder(oi);
        return true;
    }
    @GetMapping(value = "addOrderForGoods/{customerId}/{orderAmount}/{addressId}/{data}")
    public boolean addOrderForGoods(
            @PathVariable("customerId") String customerId,
            @PathVariable("orderAmount") String orderAmount,
            @PathVariable("addressId") String addressId,
            @PathVariable("data") String data){
        OrderInfo oi = new OrderInfo();
        oi.setCustomerId(Integer.parseInt(customerId));
        oi.setOrderAmount(Double.parseDouble(orderAmount));
        oi.setAddressId(Integer.parseInt(addressId));
        return shoppingService.addOrderForGoods(oi,data);
    }
}
