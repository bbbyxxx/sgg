package com.xzy.fruitmall.controller;

import com.alibaba.fastjson.JSONArray;
import com.xzy.fruitmall.biz.ResponseService;
import com.xzy.fruitmall.entity.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgg")
public class ResponseController {
    @Autowired
    private ResponseService responseService;
    //查询所有回复
    @GetMapping(value = "/getAllResponse")
    public String getResponse(){
        String str="{\"code\":1,\"msg\":\"成功\",\"data\":";
        str+= JSONArray.toJSONString(responseService.findAllResponse())+"}";
        System.out.println(str);
        return str;
    }
    //添加回复
    @PostMapping(value = "/addRespnonse/{evaluateId}/{responser}/{responseContent}")
    public boolean addResponse(ResponseInfo responseInfo){
        //responseService.addResponse(evaluateId, responser, responseContent);
        return responseService.addResponse(responseInfo);
    }
}
