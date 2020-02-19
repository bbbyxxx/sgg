package com.xzy.fruitmall.controller;

import com.xzy.fruitmall.biz.CityService;
import com.xzy.fruitmall.entity.CityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sgg")
public class CityContrller {
    @Autowired
    private CityService cityService;
    @GetMapping(value = {"/findCitiesById/{provinceId}"})
    public List<CityInfo> findCitiesById(@PathVariable("provinceId") int provinceId){
        return cityService.findCitiesById(provinceId);
    }
}
