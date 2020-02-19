package com.xzy.fruitmall.controller;


import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.biz.GoodsService;
import com.xzy.fruitmall.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgg")
public class RepertorController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = {"/findAllRepertory"})
    public String findAllRepertory(){
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findAllRepertory())+"}";
        return str;
    }

    @GetMapping(value = {"/findStockout"})
    public String findStockout(){
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findStockout())+"}";
        return str;
    }

    @GetMapping(value = {"/findRepertoryById/{goodsId}"})
    public String findRepertoryById(@PathVariable("goodsId") int goodsId){
        String str=JSONArray.toJSONString(goodsService.findRepertoryById(goodsId));
        return str;
    }

    @PutMapping(value = {"/replenishment/{goodsStock}/{goodsThreshold}/{goodsId}"})
    public String replenishment(GoodsInfo gi){
        boolean b = goodsService.replenishment(gi);
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findAllRepertory())+"}";
        return str;
    }
}
