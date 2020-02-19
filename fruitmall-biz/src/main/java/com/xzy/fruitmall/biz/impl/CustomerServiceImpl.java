package com.xzy.fruitmall.biz.impl;

import com.alibaba.fastjson.JSONArray;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.xzy.fruitmall.biz.CustomerService;
import com.xzy.fruitmall.entity.CustomerInfo;
import com.xzy.fruitmall.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override

    public List<CustomerInfo> findAllCustomer() {
        return customerMapper.findAllCustomer();
    }

    @Override
    public CustomerInfo login(String customerAccount, String customerPass) {
        return customerMapper.login(customerAccount,customerPass);
    }

    @Override
    public CustomerInfo loadCustomerInform(Integer customerId) {
        return customerMapper.loadCustomerInform(customerId);
    }
    public CustomerInfo getCustomerMsgById(int customerId) {
        return customerMapper.getCustomerMsgById(customerId);
    }

    @Override
    public boolean updateCustomerName(CustomerInfo customer) {
        int bool = customerMapper.updateCustomerName(customer);
        return  bool>0?true:false;
    }

    @Override
    public boolean updateHeadPortrait(CustomerInfo customer) {
        int bool = customerMapper.updateHeadPortrait(customer);
        return  bool>0?true:false;
    }

    public int existTel(String tel) {
        return customerMapper.existTel(tel)==null?0:1;
    }

    public String yzm(String phoneNumbers){
        int code = (int)(Math.random() * 9998 + 1);
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FjsKnQtCRDdbafag9F3", "xviNLfbv0zsEVBbDFrS2phZEsQGiKS");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumbers);
        request.putQueryParameter("SignName", "速裹果");
        request.putQueryParameter("TemplateCode", "SMS_182670413");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return String.valueOf(code);
    }

    @Override
    public int existAccount(String account) {
        return customerMapper.existAccount(account)==null?0:1;
    }

    @Override
    public String logOnCustomer(String name, String pass) {
        int code;
        CustomerInfo ci = null;
        if (customerMapper.existTel(name)!=null || customerMapper.existAccount(name)!=null){
            ci = customerMapper.logOnCustomer(name,pass);
            code = ci==null?0:1;
        }else {
            code = 2;       //没有此用户时返回
        }
        String str = "{\"code\":" + code+",\"msg\":";
        if (code == 0 || code==2){
            str += "失败,";
        }else {
            str += "成功,";
        }
        str += "\"data\":"+ JSONArray.toJSONString(ci)+"}";
        return  str;
    }

    @Override
    public String getYzm(String tel) {
        if (existTel(tel)==1){
            return yzm(tel);
        }else {
            return String.valueOf(0);
        }

    }

    @Override
    public String logOnByTel(String tel) {
        CustomerInfo ci = customerMapper.logOnByTelYzm(tel);
        String str = "{\"code\":\"1\",\"msg\":成功";
        str += "\"data\":"+JSONArray.toJSONString(ci)+"}";
        return str;
    }
}
