package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.ResponseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface ResponseSetMapper {
    Set<ResponseInfo> findResponseByEvaluateId(int evaluateId);
}
