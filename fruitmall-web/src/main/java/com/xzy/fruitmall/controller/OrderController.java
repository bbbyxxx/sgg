package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.OrderService;
import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/sgg")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/getOrderSet/{customerId}/{orderState}")
    public Set<OrderInfo> getOrderSet(@PathVariable("customerId") Integer customerId, @PathVariable("orderState") Integer orderState){

        return orderService.getOrderSet(customerId,orderState);
    }




    @GetMapping("/getAllOrderSet/{customerId}")
    public Set<OrderInfo> getAllOrderSet(@PathVariable("customerId") Integer customerId){
        return orderService.getAllOrderSet(customerId);
    }

    @PutMapping("/cancel/{orderId}")
    JSONObject cancelPay(@PathVariable("orderId") Integer orderId){
        return orderService.cancelPay(orderId);
    }

    @PutMapping("/confirmReceipt/{orderId}")
    JSONObject confirmReceipt (@PathVariable("orderId") Integer orderId){
        return orderService.confirmReceipt(orderId);
    }


    //查询所有订单
    @GetMapping(value = "/getAllorder")
    public String getOrder(){
        String str="{\"code\":1,\"msg\":\"成功\",\"data\":";
        str+=JSONArray.toJSONString(orderService.findAllOrder())+"}";
        return str;
    }
    //修改订单状态    将订单由代发货改为带收货
    @PutMapping(value = "/OrderUpdate/{orderId}")
    private String OrderUpdate(@PathVariable("orderId")Integer orderId){
        orderService.updateOrder(orderId);
        String str1="{\"code\":";
        String str2=",\"msg\":";
        String str3=",\"data\":";
        String code="1";
        String msg="\"修改成功\"";
        String data=null;

        OrderInfo orderInfo=orderService.getOrderByOrderId(orderId);
        if (orderInfo==null){
            code="0";
            msg="\"修改失败！\"";
        }else {
            data=JSONArray.toJSONString(orderService.getOrderByOrderId(orderId));
        }
        str1=str1+code+str2+msg+str3+data+"}";
        return str1;
    }
}
