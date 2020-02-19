package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.GoodsService;
import com.xzy.fruitmall.entity.AdverInfo;
import com.xzy.fruitmall.entity.GoodsInfo;
import com.xzy.fruitmall.entity.RotationInfo;
import com.xzy.fruitmall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceimpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    public List<GoodsInfo> searchClassify() {
        return goodsMapper.searchClassify();
    }

    @Override
    public List<GoodsInfo> searchClassifyGoods(GoodsInfo goodsInfo) {
        return goodsMapper.searchClassifyGoods(goodsInfo);
    }

    @Override
    public List<AdverInfo> getAdve() {
        return goodsMapper.getAdve();
    }

    @Override
    public List<RotationInfo> getRotation() {
        return goodsMapper.getRotation();
    }

    @Override
    public List<GoodsInfo> getNewGoods() {
        return goodsMapper.getNewGoods();
    }

    @Override
    public List<GoodsInfo> getHotSellGoods() {
        return goodsMapper.getHotSellGoods();
    }




    /*胡*/
    //商品管理
    @Override
    public List<GoodsInfo> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public List<GoodsInfo> findGoodsByName(String goodsName) {
        return goodsMapper.findGoodsByName(goodsName);
    }

    @Override
    public boolean deleteGoodsById(int goodsId) {
        return goodsMapper.deleteGoodsById(goodsId)>0?true:false;
    }

    @Override
    public GoodsInfo findGoodsById(int goodsId) {
        return goodsMapper.findGoodsById(goodsId);
    }

    @Override
    public boolean addGoods(GoodsInfo gi) {
        return goodsMapper.addGoods(gi)>0?true:false;
    }

    @Override
    public boolean updateGoods(GoodsInfo gi) {
        return goodsMapper.updateGoods(gi)>0?true:false;
    }

    //库存管理
    @Override
    public List<GoodsInfo> findAllRepertory() {
        return goodsMapper.findAllRepertory();
    }

    @Override
    public List<GoodsInfo> findStockout() {
        return goodsMapper.findStockout();
    }

    @Override
    public GoodsInfo findRepertoryById(int goodsId) {
        return goodsMapper.findRepertoryById(goodsId);
    }

    @Override
    public boolean replenishment(GoodsInfo gi) {
        return goodsMapper.replenishment(gi)>0?true:false;
    }

    //种类管理
    @Override
    public List<GoodsInfo> findAllSort() {
        return goodsMapper.findAllSort();
    }

    @Override
    public boolean updateSort(GoodsInfo gi) {
        return goodsMapper.updateSort(gi)>0?true:false;
    }
}
