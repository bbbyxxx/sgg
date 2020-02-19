package com.xzy.fruitmall.controller;

import com.xzy.fruitmall.biz.HeadPortraitService;
import com.xzy.fruitmall.entity.HeadPortraitInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sgg")
public class HeadPortraitController {
    @Autowired
    private HeadPortraitService headPortraitService;
    @GetMapping(value = {"/findAllHeadPortrait"})
    public List<HeadPortraitInfo> findAllHeadPortrait(){
        return headPortraitService.findAllHeadPortrait();
    }
}
