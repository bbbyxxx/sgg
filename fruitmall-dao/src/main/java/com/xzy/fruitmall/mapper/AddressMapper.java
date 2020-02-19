package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.AddressInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Mapper
@Repository
public interface AddressMapper {
    Set<AddressInfo> getAddressSetByCustomerId(Integer customerId);
    AddressInfo getAddressByAddressId(Integer orderId);
    List<AddressInfo> findAllAddress(int customerId);
    int  addAddress(AddressInfo address);
    AddressInfo getDefaultAddress(int customerId);
    int deleteAddressById(int addressId);
    int updateAddress(AddressInfo address);
    int setAddressDefault(int customerId);
}
