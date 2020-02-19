package com.xzy.fruitmall.biz;

import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.entity.EvaluateInfo;

import java.util.List;

public interface EvaluateService {
    JSONObject evaluate(Integer customerId, Integer goodsId, String evaluateContent);
    List<EvaluateInfo> findAllEvaluate();
    EvaluateInfo getEvaluateByEvaluateId(int evaluateid);
    List<EvaluateInfo>getEvaluateByEvaluateState();
}
