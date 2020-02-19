package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.CollectionInfo;

import java.util.List;

public interface CollectionService {
    List<CollectionInfo> findCollectionById(int customerId);
    boolean  collectGoods(CollectionInfo collection);
    boolean delectCollection(CollectionInfo collection);
    CollectionInfo isCollectted(CollectionInfo collection);
}
