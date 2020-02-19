package com.xzy.fruitmall.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.OrderService;
import com.xzy.fruitmall.entity.OrderInfo;
import com.xzy.fruitmall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    //这里给前端的交互表中把customerId写成userId了，记得改
    @Override
    public Set<OrderInfo> getOrderSet(Integer customerId, Integer orderState) {
        return orderMapper.getOrderSet(customerId,orderState);
    }

    @Override
    public Set<OrderInfo> getAllOrderSet(Integer customerId) {
        return orderMapper.getAllOrderSet(customerId);
    }

    @Override
    public JSONObject cancelPay(Integer orderId) {
        int num=orderMapper.cancelPay(orderId);
        String str1="{\"code\":";
        String str2=",\"msg\":";
        String str3=",\"data\":null}";
        String code="1";
        String msg="\"取消订单成功\"";
        if(num<=0){
            code="0";
            msg="\"取消订单失败\"";
        }
        str1=str1+code+str2+msg+str3;
        return JSON.parseObject(str1);
    }

    @Override
    public JSONObject confirmReceipt(Integer orderId) {
        int num=orderMapper.confirmReceipt(orderId);
        String str1="{\"code\":";
        String str2=",\"msg\":";
        String str3=",\"data\":null}";
        String code="1";
        String msg="\"确认收货成功\"";
        if(num<=0){
            code="0";
            msg="\"确认收货失败\"";
        }
        str1=str1+code+str2+msg+str3;
        return JSON.parseObject(str1);
    }

    @Override
    public List<OrderInfo> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @Override
    public boolean updateOrder(Integer orderId) {
        return orderMapper.updateOrder(orderId)>0?true:false;
    }

    @Override
    public OrderInfo getOrderByOrderId(Integer orderId) {
        return orderMapper.getOrderByOrderId(orderId);
    }

}
