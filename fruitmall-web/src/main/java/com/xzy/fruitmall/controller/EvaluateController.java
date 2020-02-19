package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.EvaluateService;
import com.xzy.fruitmall.biz.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.entity.CustomerInfo;
import com.xzy.fruitmall.entity.EvaluateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/sgg")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    //评价后就要修改评价状态，所以在这里多加了个goodsOrderServices
    @Autowired
    private GoodsOrderService goodsOrderService;
    @PostMapping("/evaluate/{orderId}/{customerId}/{goodsId}/{evaluateContent}")
    public JSONObject evaluate(@PathVariable("orderId") Integer orderId, @PathVariable("customerId") Integer customerId, @PathVariable("goodsId") Integer goodsId, @PathVariable("evaluateContent") String evaluateContent) {
        goodsOrderService.updateEvaluateState(orderId, goodsId);
        return evaluateService.evaluate(customerId, goodsId, evaluateContent);
    }
    //查询所有评价
    @GetMapping(value = "/findAllEvaluate")
    public String findAllEvaluate(){
        String str="{";
        str+= JSONArray.toJSONString(evaluateService.findAllEvaluate())+"}";
        System.out.println(str);
        return str;
    }
    //根据评价id查询
    @GetMapping(value = "/getEvaluateByEvaluateId/{evaluateId}")
    public String getEvaluateByEvaluateId(@PathVariable("evaluateId")Integer evaluateId){
        String str1="{\"code\":";
        String str2=",\"msg\":";
        String str3=",\"data\":";
        String code="1";
        String msg="\"查询成功\"";
        String str=null;
        EvaluateInfo evaluateInfo=evaluateService.getEvaluateByEvaluateId(evaluateId);
        if (evaluateInfo==null){
            code="0";
            msg="\"查询失败\"";
        }else {
            str=JSONArray.toJSONString(evaluateService.getEvaluateByEvaluateId(evaluateId));
        }
        str1=str1+code+str2+msg+str3+str+"}";
        System.out.println(str1);
        return str1;
    }
    //查询所有未回复的评价
    @GetMapping(value = "/getEvaluateByEvaluateState")
    public String getEvaluateByEvaluateState(){
        String str="{\"code\":1,\"msg\":\"成功\",\"data\":";
        str+=JSONArray.toJSONString(evaluateService.getEvaluateByEvaluateState())+"}";
        System.out.println(str);
        return str;
    }
}
