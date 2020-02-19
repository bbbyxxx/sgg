package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.EvaluateInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Mapper
public interface EvaluateSetMapper {
    Set<EvaluateInfo> findEvaluateByGoodsId(int goodsId);
}
