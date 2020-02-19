package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sgg")
public class GoodsOrderController {
    @Autowired
    private GoodsOrderService goodsOrderService;
    //由于获取待评价的商品.和OrderController中获取各种订单是有区别的(一开始认为是一样的来着)，当时未考虑到，所以之后将二者分离，为了调用时思路清晰，就写在这里
    @GetMapping("/getWaitForEvaluate/{customerId}")
    public JSONObject getWaitForEvaluateGoodsSet(@PathVariable("customerId") Integer customerId) {
        return goodsOrderService.getWaitForEvaluateGoodsSet(customerId);
    }

    @GetMapping("/getOrderGoodsInfoByGoodsName/{customerId}/{goodsName}")
    public JSONObject getOrderGoodsInfoByGoodsName(@PathVariable("customerId") Integer customerId, @PathVariable("goodsName")String goodsName){
        System.out.println(customerId+""+goodsName);
        return goodsOrderService.getOrderGoodsInfoByGoodsName(customerId, goodsName);
    }

}
