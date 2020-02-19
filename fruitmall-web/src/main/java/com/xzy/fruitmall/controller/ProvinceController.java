package com.xzy.fruitmall.controller;

import com.xzy.fruitmall.biz.ProvinceService;
import com.xzy.fruitmall.entity.ProvinceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sgg")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @GetMapping(value = {"/findAllProvinces"})
    public List<ProvinceInfo>  findAllProcinces(){
        return provinceService.findAllProcinces();
    }
}
