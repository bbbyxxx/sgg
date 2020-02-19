package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.OrderInfo;

public interface ShoppingService {
    String shoppingCartDisplay(String customerId);
    boolean addOrderForGoods(OrderInfo oi, String data);
    int addOrder(OrderInfo oi);


    }
