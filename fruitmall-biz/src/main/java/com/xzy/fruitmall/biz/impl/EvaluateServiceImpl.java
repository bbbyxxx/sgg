package com.xzy.fruitmall.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.EvaluateService;
import com.xzy.fruitmall.entity.EvaluateInfo;
import com.xzy.fruitmall.mapper.EvaluateMapper;
import com.xzy.fruitmall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public JSONObject evaluate(Integer customerId, Integer goodsId, String evaluateContent) {
            int num=evaluateMapper.evaluate(customerId, goodsId, evaluateContent);
            String str1="{\"code\":";
            String str2=",\"msg\":";
            String str3=",\"data\":null}";
            String code="1";
            String msg="\"评价成功\"";
            if(num<=0){
                code="0";
                msg="\"评价失败\"";
            }
            str1=str1+code+str2+msg+str3;
            return JSON.parseObject(str1);
    }

    public List<EvaluateInfo> findAllEvaluate() {
        return evaluateMapper.findAllEvaluate();
    }

    @Override
    public EvaluateInfo getEvaluateByEvaluateId(int evaluateId) {
        return evaluateMapper.getEvaluateByEvaluateId(evaluateId);
    }

    @Override
    public List<EvaluateInfo> getEvaluateByEvaluateState() {
        return evaluateMapper.getEvaluateByEvaluateState();
    }
}
