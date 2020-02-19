package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.ProvinceService;
import com.xzy.fruitmall.entity.ProvinceInfo;
import com.xzy.fruitmall.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProcinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper pm;
    @Override
    public List<ProvinceInfo> findAllProcinces() {
        return pm.findAllProcinces();
    }
}
