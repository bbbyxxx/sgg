package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.AdverInfo;
import com.xzy.fruitmall.entity.GoodsInfo;
import com.xzy.fruitmall.entity.RotationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    GoodsInfo getSketchyGoodsByGoodsId(Integer goodsId);
    GoodsInfo getGoodsByGoodsId(Integer goodsId);
    List<GoodsInfo> searchClassify();
    List<GoodsInfo> searchClassifyGoods(GoodsInfo goodsInfo);
    List<AdverInfo>getAdve();
    List<RotationInfo>getRotation();
    List<GoodsInfo>getNewGoods();
    List<GoodsInfo>getHotSellGoods();


   /*胡*/
    List<GoodsInfo> findAllGoods();
    List<GoodsInfo> findGoodsByName(String goodsName);
    int deleteGoodsById(int goodsId);
    GoodsInfo findGoodsById(int goodsId);
    int addGoods(GoodsInfo gi);
    int updateGoods(GoodsInfo gi);

    List<GoodsInfo> findAllRepertory();
    List<GoodsInfo> findStockout();
    GoodsInfo findRepertoryById(int goodsId);
    int replenishment(GoodsInfo gi);

    List<GoodsInfo> findAllSort();
    int updateSort(GoodsInfo gi);
}
