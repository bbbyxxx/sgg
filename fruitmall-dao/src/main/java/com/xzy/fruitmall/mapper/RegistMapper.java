package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegistMapper {
    CustomerInfo judgeCustomerAccountExist(CustomerInfo customerInfo);
    int registPerson(CustomerInfo customerInfo);
}
