package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.AddressService;
import com.xzy.fruitmall.entity.AddressInfo;
import com.xzy.fruitmall.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper am;

    @Override
    public List<AddressInfo> findAllAddress(int customerId) {
        return am.findAllAddress(customerId);
    }

    @Override
    public boolean addAddress(AddressInfo address) {
        int bool = am.addAddress(address);
        return  bool>0?true:false;
    }

    @Override
    public AddressInfo getDefaultAddress(int customerId) {
        return am.getDefaultAddress(customerId);
    }

    @Override
    public boolean deleteAddressById(int addressId) {
        int bool = am.deleteAddressById(addressId);
        return  bool>0?true:false;
    }


    @Override
    public boolean updateAddress(AddressInfo address) {
        int bool = am.updateAddress(address);
        return  bool>0?true:false;
    }

    @Override
    public boolean setAddressDefault(int customerId) {
        int bool = am.setAddressDefault(customerId);
        return bool>0?true:false;
    }

}
