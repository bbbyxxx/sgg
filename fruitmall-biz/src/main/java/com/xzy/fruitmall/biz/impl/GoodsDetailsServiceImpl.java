package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.GoodsDetailsService;
import com.xzy.fruitmall.entity.GoodsInfo;
import com.xzy.fruitmall.mapper.GoodsDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailsServiceImpl implements GoodsDetailsService {
    @Autowired
    private GoodsDetailsMapper gdm;

    @Override
    public GoodsInfo findAllAboutTheGood(int goodsId) {
        return gdm.findAllAboutTheGood(goodsId);
    }
}
