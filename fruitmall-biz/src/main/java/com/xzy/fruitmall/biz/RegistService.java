package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.CustomerInfo;


public interface RegistService {
    CustomerInfo judgeCustomerAccountExist(CustomerInfo customerInfo);
    int registPerson(CustomerInfo customerInfo);
}
