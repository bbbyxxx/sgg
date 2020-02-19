package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.AddressInfo;

import java.util.List;

public interface AddressService {
    List<AddressInfo> findAllAddress(int customerId);
    boolean  addAddress(AddressInfo address);
    AddressInfo getDefaultAddress(int customerId);
    boolean deleteAddressById(int addressId);
    boolean  updateAddress(AddressInfo address);
    boolean setAddressDefault(int customerId);
}
