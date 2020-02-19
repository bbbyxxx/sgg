package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sgg")
public class ServiceToCustomer {

    @GetMapping("/getservice")
    public JSONObject getService(){
        String s = "{\"code\":\""+1+"\",\"msg\":\"successful\",\"data\":\"对不起，没有客服！\"}";
        return JSON.parseObject(s);
    }
}
