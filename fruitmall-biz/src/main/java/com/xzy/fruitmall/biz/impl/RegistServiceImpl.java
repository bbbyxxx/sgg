package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.RegistService;
import com.xzy.fruitmall.entity.CustomerInfo;
import com.xzy.fruitmall.mapper.RegistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistServiceImpl implements RegistService {
    @Autowired
    private RegistMapper rm;

    @Override
    public CustomerInfo judgeCustomerAccountExist(CustomerInfo customerInfo) {
        return rm.judgeCustomerAccountExist(customerInfo);
    }

    @Override
    public int registPerson(CustomerInfo customerInfo) {
        return rm.registPerson(customerInfo);
    }
}
