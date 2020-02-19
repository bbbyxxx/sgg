package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.biz.CustomerService;
import com.xzy.fruitmall.entity.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgg")
public class LogOn {
    @Autowired
    private CustomerService customerService;
    @GetMapping(value = "/getYzm/{tel}")
    public String getYzm(@PathVariable("tel") String tel){
        return customerService.getYzm(tel);
    }
    @GetMapping(value = "/logOnByTel/{tel}")
    public String logOnByTel(@PathVariable("tel")String tel){
        return customerService.logOnByTel(tel);
    }
}
