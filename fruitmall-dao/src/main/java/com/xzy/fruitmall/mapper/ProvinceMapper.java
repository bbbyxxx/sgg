package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.ProvinceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProvinceMapper {
    List<ProvinceInfo> findAllProcinces();
}
