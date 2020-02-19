package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.biz.GoodsService;
import com.xzy.fruitmall.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sgg")
public class SortController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = {"/findAllSort"})
    public String findAllSort(){
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findAllSort())+"}";
        return str;
    }

    @PutMapping(value = {"/updateSort/{goodsSort}/{goodsId}"})
    public String updateSort(GoodsInfo gi){
        boolean b = goodsService.updateSort(gi);
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findAllSort())+"}";
        return str;
    }
}
