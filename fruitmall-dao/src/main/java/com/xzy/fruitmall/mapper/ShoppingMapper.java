package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.GoodsOrderInfo;
import com.xzy.fruitmall.entity.OrderInfo;
import com.xzy.fruitmall.entity.ShoppingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ShoppingMapper {
    List<ShoppingInfo> shoppingCartDisplay(String customerId);
    int addOrder(OrderInfo oi);
    int addOrderForGoods(GoodsOrderInfo goodsOrderInfo);
}
