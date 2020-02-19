package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.CustomerService;
import com.xzy.fruitmall.entity.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sgg")
public class TestController {
    @Autowired
    private CustomerService customerService;

    //测试
    @GetMapping(value = "/test")
    public String test(){
        List<CustomerInfo>list=customerService.findAllCustomer();
        String str="{\"code\":1,\"msg\":\"成功\",\"data\":";
        str+=JSONArray.toJSONString(customerService.findAllCustomer())+"}";
        System.out.println(str);
        return str;
    }
    //账号或手机号 密码登录
    @GetMapping(value = "/login/{customerAccount}/{customerPass}")
    public JSONObject login(@PathVariable("customerAccount")String customerAccount, @PathVariable("customerPass")String customerPass){
        String str1="{\"code\":";
        String str2=",\"msg\":";
        String str3=",\"data\":";
        String code="1";
        String msg="\"登录成功\"";
        String str=null;
        CustomerInfo customerInfo=customerService.login(customerAccount,customerPass);
        System.out.println(customerInfo);
        if (customerInfo==null){
            code="0";
            msg="\"账号密码不对\"";
        }else {
            str=JSONArray.toJSONString(customerService.login(customerAccount,customerPass));
        }
        str1=str1+code+str2+msg+str3+str+"}";
        System.out.println(str1);
        return JSON.parseObject(str1);
    }
    //查询用户，返回用户信息
    @GetMapping("/load/{customerId}")
    public CustomerInfo loadCustomerInform(@PathVariable("customerId") Integer customerId){
        CustomerInfo customerInfo=customerService.loadCustomerInform(1);
        System.out.println(customerInfo);
        return customerInfo;
    }


}
