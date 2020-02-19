package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.HeadPortraitService;
import com.xzy.fruitmall.entity.HeadPortraitInfo;
import com.xzy.fruitmall.mapper.HeadPortraitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadPortraitServiceImpl implements HeadPortraitService {
    @Autowired
    private HeadPortraitMapper hpm;

    @Override
    public List<HeadPortraitInfo> findAllHeadPortrait() {
        return hpm.findAllHeadPortrait();
    }
}
