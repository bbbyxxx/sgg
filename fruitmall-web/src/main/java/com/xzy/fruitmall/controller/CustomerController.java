package com.xzy.fruitmall.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xzy.fruitmall.biz.CustomerService;
import com.xzy.fruitmall.entity.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgg")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping(value={"/findCustomer/{customerAccount}/{customerPass}"})
    public JSONObject login(@PathVariable("customerAccount") String customerAccount, @PathVariable("customerPass") String customerPass) {
        String str1 = "{\"code\":";
        String str2 = ",\"msg\":";
        String str3 = ",\"data\":";
        String code = "1";
        String msg = "\"登录成功\"";
        String data = null;
        CustomerInfo customerInfo = customerService.login(customerAccount, customerPass);
        System.out.println(customerInfo);
        if (customerInfo == null) {
            code = "0";
            msg = "\"账号密码不匹配！\"";
        } else {
            data = JSONArray.toJSONString(customerService.loadCustomerInform(customerInfo.getCustomerId()), SerializerFeature.DisableCircularReferenceDetect);
        }
        str1 = str1 + code + str2 + msg + str3 + data + "}";
        System.out.println(str1);
        return JSON.parseObject(str1);
    }
    @GetMapping(value = {"/getCustomerMsg/{customerId}"})
    public CustomerInfo getCustomerMsg(@PathVariable("customerId") int customerId){
        return customerService.getCustomerMsgById(customerId);
    }

    @PutMapping(value = {"/updateCustomerName/{customerId}/{nickName}"})
    public String updateCustomerName(CustomerInfo customer){
        boolean bool = customerService.updateCustomerName(customer);
        String code,msg;
        if(bool){
            code="1";
            msg="\"昵称修改成功！\"";
        }else{
            code="0";
            msg="\"昵称修改失败！\"";
        }
        String status="{\"code\":"+code+",\"msg\":"+msg+"}";
        return status;
    }

    @PutMapping(value = {"/updateHeadPortrait/{customerId}/{headPortraitId}"})
    public String updateHeadPortrait(CustomerInfo customer){
        boolean bool = customerService.updateHeadPortrait(customer);
        String code,msg;
        if(bool){
            code="1";
            msg="\"更换头像成功！\"";
        }else{
            code="0";
            msg="\"更换头像失败！\"";
        }
        String status="{\"code\":"+code+",\"msg\":"+msg+"}";
        return status;
    }
}
