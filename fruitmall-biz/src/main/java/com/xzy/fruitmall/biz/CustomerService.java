package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.CustomerInfo;

import java.util.List;

public interface CustomerService {
    List<CustomerInfo> findAllCustomer();
    CustomerInfo login(String customerAccount, String customerPass);
    CustomerInfo loadCustomerInform(Integer customerId);
    CustomerInfo getCustomerMsgById(int customerId);
    boolean updateCustomerName(CustomerInfo customer);
    boolean updateHeadPortrait(CustomerInfo customer);
    int existTel(String tel);
    int existAccount(String account);
    String logOnCustomer(String name,String pass);
    String getYzm(String tel);
    String logOnByTel(String tel);
}
