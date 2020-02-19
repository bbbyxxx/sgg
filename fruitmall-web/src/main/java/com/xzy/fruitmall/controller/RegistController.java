package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.RegistService;
import com.xzy.fruitmall.entity.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sgg")
public class RegistController {
    @Autowired
    private RegistService rs;

    @PostMapping("/regist/{customerAccount}/{customerPass}/{customerTel}/{nickName}/{customerSex}")
    public JSONObject registSomePerson(CustomerInfo customerInfo){
        String s = "{\"msg\":\"此账号不可用！\"}";
        CustomerInfo ci = rs.judgeCustomerAccountExist(customerInfo);
        if (ci==null){
            int i = rs.registPerson(customerInfo);
            if (i>0){
                s = "{\"msg\":\"注册成功！\"}";
            }
        }
        return JSON.parseObject(s);
    }
}
