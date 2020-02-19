package com.xzy.fruitmall.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.ShoppingService;
import com.xzy.fruitmall.entity.GoodsOrderInfo;
import com.xzy.fruitmall.entity.OrderInfo;
import com.xzy.fruitmall.entity.ShoppingInfo;
import com.xzy.fruitmall.mapper.ShoppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public int addOrder(OrderInfo oi){
        if (shoppingMapper.addOrder(oi)<1){
            return 0;
        }
        return oi.getOrderId();
    }

    @Override
    public boolean addOrderForGoods(OrderInfo oi, String data) {
        int orderId = addOrder(oi);
        if (orderId==0){
            return false;
        }
        JSONArray jsonArray = JSON.parseArray(data);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String goodsId = jsonObject.getString("goodsId");
            String goodsNum = jsonObject.getString("goodsNum");
            GoodsOrderInfo goodsOrderInfo = new GoodsOrderInfo();
            goodsOrderInfo.setOrderId(orderId);
            goodsOrderInfo.setGoodsId(Integer.parseInt(goodsId));
            goodsOrderInfo.setGoodsNum(Integer.parseInt(goodsNum));
            if (shoppingMapper.addOrderForGoods(goodsOrderInfo)<1)
                return false;

        }
        return true;
    }

    @Override
    public String shoppingCartDisplay(String customerId) {
        List<ShoppingInfo> list = shoppingMapper.shoppingCartDisplay(customerId);
        String str = "{\"code\":";
        String msg = "失败";
        if (list.isEmpty()){
            str += 0;
        }else {
            str += 1;
            msg = "成功";
        }
        str += ",\"data\":\"" + JSONArray.toJSONString(list) + "\",\"msg\":\"" + msg +"\"}";
        return str;
    }
}
