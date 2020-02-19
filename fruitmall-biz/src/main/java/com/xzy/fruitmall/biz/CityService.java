package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.CityInfo;

import java.util.List;

public interface CityService {
    List<CityInfo> findCitiesById(int provinceId);
}
