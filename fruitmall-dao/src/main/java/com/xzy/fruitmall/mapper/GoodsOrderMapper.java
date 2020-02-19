package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.GoodsInfo;
import com.xzy.fruitmall.entity.GoodsOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface GoodsOrderMapper {
    Set<GoodsOrderInfo> getGoodsOrderSetByOrderId(Integer orderId);

    //查找待评价的商品
    Set<GoodsInfo> getWaitForEvaluateGoodsSet(Integer customerId);

    //按照名字模糊查询订单中的商品
    Set<GoodsInfo> getOrderGoodsInfoByGoodsName(@Param("customerId") Integer customerId, @Param("goodsName") String goodsName);

    void updateEvaluateState(@Param("orderId") Integer orderId, @Param("goodsId") Integer goodsId);
}
