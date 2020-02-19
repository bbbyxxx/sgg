package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.CityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CityMappper {
    List<CityInfo> findCitiesById(int provinceId);
}
