package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzy.fruitmall.biz.GoodsDetailsService;
import com.xzy.fruitmall.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sgg")
public class GoodsDetailsController {
    @Autowired
    private GoodsDetailsService gds;//商品详情操作类

    @GetMapping("/getallaboutthegood/{goodsId}")
    public JSONObject GetAllMessagesAboutTheGood(@PathVariable("goodsId")String goodsId){
         GoodsInfo goodsInfo = gds.findAllAboutTheGood(Integer.parseInt(goodsId));
         Integer code = 0;
         String str = null;
         String msg = "false";
         if (goodsInfo!=null){
             code = 1;
             str = "{\"code\":\""+code+"\",\"data\":";
             str += JSONArray.toJSONString(goodsInfo);
             str += ",\"msg\":\"successful\"";
             str += "}";
         }else{
             str = "{\"code\":\""+code+"\",\"data\":\"null\",\"msg\":\""+msg+"\"}";
         }

         return JSON.parseObject(str);
    }
}
