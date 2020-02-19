package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.EvaluateInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvaluateMapper {
    List<EvaluateInfo> getEvaluateSetByCustomerId(Integer CustomerId);

    List<EvaluateInfo> getEvaluateSetByGoodsId(Integer goodsId);

    int evaluate(@Param("customerId") Integer customerId, @Param("goodsId") Integer goodsId, @Param("evaluateContent") String evaluateContent);
    List<EvaluateInfo>findAllEvaluate();
    EvaluateInfo getEvaluateByEvaluateId(int evaluateid);
    List<EvaluateInfo> getEvaluateByEvaluateState();
}
