package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.biz.GoodsService;
import com.xzy.fruitmall.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sgg")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    //获取商品的分类
    @GetMapping(value={"/searchClassify"})
    public String searchClassify(){
        return JSONArray.toJSONString(goodsService.searchClassify());
    }
    //获取分类下的商品
    @GetMapping(value ={"/searchClassifyGoods/{goodsSort}"})
    public String searchClassifyGoods(GoodsInfo goodsInfo){
        return JSONArray.toJSONString((goodsService.searchClassifyGoods(goodsInfo)));
    }
    //获取广告
    @GetMapping(value = {"/getAdve"})
    public String getAdve(){
        return  JSONArray.toJSONString(goodsService.getAdve());
    }
    //获取商品轮播图
    @GetMapping(value = {"/getRotation"})
    public String getRotation(){
        return JSONArray.toJSONString(goodsService.getRotation());
    }
    //获取新品
    @GetMapping(value = {"/getNewGoods"})
    public String getNewGoods(){
        return JSONArray.toJSONString(goodsService.getNewGoods());
    }
    //获取热销品
    @GetMapping(value = {"/getHotSellGoods"})
    public String getHotSellGoods(){
    return JSONArray.toJSONString(goodsService.getHotSellGoods());
    }




    @GetMapping(value = {"/allGoods"})
    public String allGoods(){
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findAllGoods())+"}";
        return str;
    }

    @GetMapping(value = {"/findGoodsByName/{goodsName}"})
    public String findGoodsByName(@PathVariable("goodsName") String goodsName){
        //String str = "{";
        String str=JSONArray.toJSONString(goodsService.findGoodsByName(goodsName));//+"}";
        return str;
    }

    @DeleteMapping(value = {"/deleteGoodsById/{goodsId}"})
    public String deleteGoodsById(@PathVariable("goodsId") int goodsId){
        boolean b = goodsService.deleteGoodsById(goodsId);
        String str;
        if(b){
            str="{"+JSONArray.toJSONString(goodsService.findAllGoods())+"}";
        }else {
            str="{"+"msg:"+"修改失败"+"}";
        }
        return str;
    }

    @GetMapping(value = {"/findGoodsById/{goodsId}"})
    public String findGoodsById(@PathVariable("goodsId") int goodsId){
        //String str = "{";
        String str=JSONArray.toJSONString(goodsService.findGoodsById(goodsId));//+"}";
        return str;
    }

    @PutMapping(value = {"/updateGoods/{goodsName}/{goodsPrice}/{goodsSort}/{goodsDescription}/{goodsStock}/{goodsThreshold}" +
            "{goodsOrigin}/{storageConditions}/{goodsBrand}/{picPath}/{goodsId}"})
    public String updateGoods(@PathVariable("gi") GoodsInfo gi){
        boolean b = goodsService.updateGoods(gi);
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findAllGoods())+"}";
        return str;
    }

    @PostMapping(value = {"/addGoods/{goodsName}/{goodsPrice}/{goodsSort}/{goodsDescription}/{goodsStock}" +
            "/{goodsThreshold}/{goodsOrigin}/{storageConditions}/{goodsBrand}/{picPath}"})
    public String addGoods(@PathVariable("gi") GoodsInfo gi){
        boolean b = goodsService.addGoods(gi);
        String str = "{";
        str+= JSONArray.toJSONString(goodsService.findAllGoods())+"}";
        return str;
    }
}
