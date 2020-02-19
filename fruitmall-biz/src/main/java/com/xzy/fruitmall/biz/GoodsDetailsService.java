package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.GoodsInfo;

public interface GoodsDetailsService {
    GoodsInfo findAllAboutTheGood(int goodsId);
}
