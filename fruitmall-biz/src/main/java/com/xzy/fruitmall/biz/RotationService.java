package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.RotationInfo;

import java.util.List;

public interface RotationService {
    List<RotationInfo> getAllRotation();
    Boolean deleteRotation(Integer rotationId);
    Boolean addRotation(RotationInfo rotationInfo);
}
