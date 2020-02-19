package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.EvaluateInfo;
import com.xzy.fruitmall.entity.ResponseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResponseMapper {
    List<EvaluateInfo> getResponseSetByEvaluateId(Integer evaluateId);
    List<ResponseInfo>findAllResponse();
    int addResponse(ResponseInfo responseInfo);
    ResponseInfo getResponseByAualuateId(Integer avaluateId);
}
