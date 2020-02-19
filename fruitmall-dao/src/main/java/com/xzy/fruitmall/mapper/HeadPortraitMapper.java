package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.HeadPortraitInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HeadPortraitMapper {
    //根据头像id查询头像信息，配合CustomerMapper载入详细信息
    HeadPortraitInfo getHeadPortraitById(Integer headPortraitById);
    List<HeadPortraitInfo> findAllHeadPortrait();
}
