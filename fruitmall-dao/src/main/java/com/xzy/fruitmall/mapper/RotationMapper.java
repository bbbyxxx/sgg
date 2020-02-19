package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.RotationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RotationMapper {
    List<RotationInfo> getAllRotation();
    int deleteRotation(Integer rotationId);
    int addRotation(RotationInfo rotationInfo);
}
