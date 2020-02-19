package com.xzy.fruitmall.biz;

import com.alibaba.fastjson.JSONObject;


public interface GoodsOrderService {
    JSONObject getWaitForEvaluateGoodsSet(Integer customerId);
    void updateEvaluateState(Integer orderId, Integer goodsId);
    JSONObject getOrderGoodsInfoByGoodsName(Integer customerId, String goodsName);

}
