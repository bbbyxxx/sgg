package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface OrderMapper {
    Set<OrderInfo> getOrderSetByCustomerId(Integer customerId);

    /*查询某种订单，如待付款、待收货，这里面封装了订单的详细信息，
     如果点商品主体进入订单详细界面，只要把订单地址额外展示出来即可*/
    Set<OrderInfo> getOrderSet(Integer customerId, Integer orderState);


    //查询全部订单，同上，只是各种类都查
    Set<OrderInfo> getAllOrderSet(Integer customerId);


    //付款接口由淡拓实现
    //int pay(Integer orderId);

    int cancelPay(Integer orderId);
    int confirmReceipt(Integer orderId);

    List<OrderInfo>findAllOrder();
    int updateOrder(Integer orderId);
    OrderInfo getOrderByOrderId(Integer orderId);
}
