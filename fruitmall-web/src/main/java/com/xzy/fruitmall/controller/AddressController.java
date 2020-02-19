package com.xzy.fruitmall.controller;

import com.xzy.fruitmall.biz.AddressService;
import com.xzy.fruitmall.entity.AddressInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgg")
public class AddressController  {
    @Autowired
    private AddressService addressService;
    @GetMapping(value = {"/findAllAddress/{customerId}"})
    public List<AddressInfo>  findAllAddress(@PathVariable("customerId") int customerId){
        return addressService.findAllAddress(customerId);
    }
    @GetMapping(value = {"/getDefaultAddress/{customerId}"})
    public AddressInfo getDefaultAddress(@PathVariable("customerId") int customerId){
        return addressService.getDefaultAddress(customerId);
    }
    @PostMapping(value = {"addAddress/{customerId}/{consignee}/{consigneeAddress}/{consigneeTel}/{isDefault}"})
    public String addAddress(AddressInfo address){
        int isDefault = address.getIsDefault();
        if(isDefault==1){
            addressService.setAddressDefault(address.getCustomerId());
        }
        boolean bool = addressService.addAddress(address);
        String status;
        String code,msg;
        if(bool){
            code="1";
            msg="\"收货地址添加成功！\"";
        }else{
            code="0";
            msg="\"收货地址添加失败！\"";
        }
        status="{\"code\":"+code+",\"msg\":"+msg+"}";
        return status;
    }
    @DeleteMapping(value = {"deleteAddressById/{addressId}"})
    public String deleteAddressById(@PathVariable("addressId")int addressId){
        boolean bool = addressService.deleteAddressById(addressId);
        String status;
        String code,msg;
        if(bool){
            code="1";
            msg="\"收货地址删除成功！\"";
        }else{
            code="0";
            msg="\"收货地址删除失败！\"";
        }
        status="{\"code\":"+code+",\"msg\":"+msg+"}";
        return status;
    }

    @PutMapping(value = {"updateAddress/{addressId}/{customerId}/{consignee}/{consigneeAddress}/{consigneeTel}/{isDefault}"})
    public String updateAddress(AddressInfo address){
       int isDefault = address.getIsDefault();
        if(isDefault==1){
            addressService.setAddressDefault(address.getCustomerId());
        }
        boolean bool = addressService.updateAddress(address);
        String status;
        String code,msg;
        if(bool){
            code="1";
            msg="\"收货地址修改成功！\"";
        }else{
            code="0";
            msg="\"收货地址修改失败！\"";
        }
        status="{\"code\":"+code+",\"msg\":"+msg+"}";
        return status;
    }
}
