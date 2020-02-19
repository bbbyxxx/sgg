package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.RotationService;
import com.xzy.fruitmall.entity.RotationInfo;
import com.xzy.fruitmall.mapper.RotationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotationServiceImpl implements RotationService {
    @Autowired
    private RotationMapper rotationMapper;
    public List<RotationInfo> getAllRotation() {
        return rotationMapper.getAllRotation();
    }

    @Override
    public Boolean deleteRotation(Integer rotationId) {
        return rotationMapper.deleteRotation(rotationId)>0?true:false;
    }

    @Override
    public Boolean addRotation(RotationInfo rotationInfo) {
        return rotationMapper.addRotation(rotationInfo)>0?true:false;
    }
}
