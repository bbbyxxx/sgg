package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.ImgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface ImgMapper {
    Set<ImgInfo> getImgByGoodsId(Integer goodsId);
}
