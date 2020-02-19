package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.biz.RotationService;
import com.xzy.fruitmall.entity.RotationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgg")
public class RotationController {
    @Autowired private RotationService rotationService;
    //查询所有轮播图
    @GetMapping(value = "/getAllRotation")
    public String getAllRotation(){
        String str="{";
        str+=JSONArray.toJSONString(rotationService.getAllRotation())+"}";

        System.out.println(str);
        return str;
    }
    //删除轮播图
    @DeleteMapping(value = "/deleteRotationByRotationId/{rotationId}")
    public boolean deleteRotation(@PathVariable("rotationId")Integer rotationId){
        return rotationService.deleteRotation(rotationId);
    }
    //添加轮播图
    @PostMapping(value = "/addRotation/{imgPath}/{goodsId}")
    public Boolean addRotation(RotationInfo rotationInfo){

        return rotationService.addRotation(rotationInfo);
    }
}
