package com.xzy.fruitmall.mapper;

import com.xzy.fruitmall.entity.CollectionInfo;
import com.xzy.fruitmall.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CollectionMapper {
    List<CollectionInfo> getCollectionSetByCustomerId(Integer customerId);
    List<CollectionInfo> findCollectionById(int customerId);
    int collectGoods(CollectionInfo collection);
    int delectCollection(CollectionInfo collection);
    GoodsInfo findGoodsById(int goodsId);
    CollectionInfo isCollectted(CollectionInfo collection);
}
