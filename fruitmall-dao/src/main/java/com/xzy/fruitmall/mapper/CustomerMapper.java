package com.xzy.fruitmall.mapper;
import com.xzy.fruitmall.entity.CollectionInfo;
import  com.xzy.fruitmall.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {
    //查找所有用户
    List<CustomerInfo> findAllCustomer();
    //登录验证
    CustomerInfo login(String customerAccount, String customerPass);
    //载入用户的详细信息
    CustomerInfo loadCustomerInform(Integer customerId);

    CustomerInfo getCustomerMsgById(int customerId);
    int updateCustomerName(CustomerInfo customer);
    int updateHeadPortrait(CustomerInfo customer);
    CustomerInfo existTel(String tel);
    CustomerInfo existAccount(String account);
    CustomerInfo logOnCustomer(String name,String pass);
    CustomerInfo logOnByTelYzm(String tel);
//    List<CustomerInfo> findCustomerByAccount(String name,String pass);
//    List<CustomerInfo> findCustomerByTel(String tel);
//    List<CustomerInfo> findCustomerByPass(String tel,String pass);
//    List<CustomerInfo> getHeadPortratitById(int headPortraitId);
//    List<CustomerInfo> getCollection(int account);
}
