package com.xzy.fruitmall.biz;

import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.entity.OrderInfo;

import java.util.List;
import java.util.Set;


public interface OrderService {
    Set<OrderInfo> getOrderSet(Integer customerId, Integer orderState);
    Set<OrderInfo> getAllOrderSet(Integer customerId);
    //付款接口由淡拓实现
    //JSONPObject pay(Integer orderId);
    JSONObject cancelPay(Integer orderId);
    JSONObject confirmReceipt(Integer orderId);
    List<OrderInfo> findAllOrder();
    boolean updateOrder(Integer orderId);
    OrderInfo getOrderByOrderId(Integer orderId);


}