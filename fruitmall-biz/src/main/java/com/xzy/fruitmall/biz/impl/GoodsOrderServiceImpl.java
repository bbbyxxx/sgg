package com.xzy.fruitmall.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.GoodsOrderService;
import com.xzy.fruitmall.mapper.GoodsOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsOrderServiceImpl implements GoodsOrderService {
    @Autowired
    private GoodsOrderMapper goodsOrderMapper;
    @Override
    public JSONObject getWaitForEvaluateGoodsSet(Integer customerId) {
        String str1="{\"code\":";
        String str2=",\"msg\":";
        String str3=",\"data\":";
        String code="1";
        String msg="\"查询成功\"";
        String data= JSONArray.toJSONString(goodsOrderMapper.getWaitForEvaluateGoodsSet(customerId));
        if (data==null||data.isEmpty()){
            code="0";
            msg="\"查询失败！\"";
        }else{
        }
        str1=str1+code+str2+msg+str3+data+"}";
        return JSON.parseObject(str1);
    }

    @Override
    public void updateEvaluateState(Integer orderId, Integer goodsId) {
        goodsOrderMapper.updateEvaluateState(orderId,goodsId);
    }

    @Override
    public JSONObject getOrderGoodsInfoByGoodsName(Integer customerId, String goodsName) {
        String str1="{\"code\":";
        String str2=",\"msg\":";
        String str3=",\"data\":";
        String code="1";
        String msg="\"查询成功\"";
        String data= JSONArray.toJSONString(goodsOrderMapper.getOrderGoodsInfoByGoodsName(customerId, goodsName));
        if (data==null||data.isEmpty()){
            code="0";
            msg="\"查询失败！\"";
        }else{
        }
        str1=str1+code+str2+msg+str3+data+"}";
        return JSON.parseObject(str1);
    }


}
