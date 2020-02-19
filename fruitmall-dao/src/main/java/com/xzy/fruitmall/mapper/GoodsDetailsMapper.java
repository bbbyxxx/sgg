package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsDetailsMapper {
    GoodsInfo findAllAboutTheGood(int goodsId);
}

