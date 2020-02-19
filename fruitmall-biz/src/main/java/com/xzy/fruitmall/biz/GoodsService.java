package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.AdverInfo;
import com.xzy.fruitmall.entity.GoodsInfo;
import com.xzy.fruitmall.entity.RotationInfo;

import java.util.List;

public interface GoodsService {
    List<GoodsInfo> searchClassify();
    List<GoodsInfo> searchClassifyGoods(GoodsInfo goodsInfo);
    List<AdverInfo>getAdve();
    List<RotationInfo>getRotation();
    List<GoodsInfo>getNewGoods();
    List<GoodsInfo>getHotSellGoods();



/*胡*/
    List<GoodsInfo> findAllGoods();
    List<GoodsInfo> findGoodsByName(String goodsName);
    boolean deleteGoodsById(int goodsId);
    GoodsInfo findGoodsById(int goodsId);
    boolean addGoods(GoodsInfo gi);
    boolean updateGoods(GoodsInfo gi);

    List<GoodsInfo> findAllRepertory();
    List<GoodsInfo> findStockout();
    GoodsInfo findRepertoryById(int goodsId);
    boolean replenishment(GoodsInfo gi);

    List<GoodsInfo> findAllSort();
    boolean updateSort(GoodsInfo gi);
}
