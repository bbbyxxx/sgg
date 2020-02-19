package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.CityService;
import com.xzy.fruitmall.entity.CityInfo;
import com.xzy.fruitmall.mapper.CityMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMappper cm;

    @Override
    public List<CityInfo> findCitiesById(int provinceId) {
        return cm.findCitiesById(provinceId);
    }
}
