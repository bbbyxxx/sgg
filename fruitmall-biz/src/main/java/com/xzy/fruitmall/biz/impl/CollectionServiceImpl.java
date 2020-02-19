package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.CollectionService;
import com.xzy.fruitmall.entity.CollectionInfo;
import com.xzy.fruitmall.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper cm;
    @Override
    public List<CollectionInfo> findCollectionById(int customerId) {
        return cm.findCollectionById(customerId);
    }

    @Override
    public boolean collectGoods(CollectionInfo collection) {
        int bool = cm.collectGoods(collection);
        return  bool>0?true:false;
    }

    @Override
    public boolean delectCollection(CollectionInfo collection) {
        int bool = cm.delectCollection(collection);
        return  bool>0?true:false;
    }

    @Override
    public CollectionInfo isCollectted(CollectionInfo collection) {

        return cm.isCollectted(collection);
    }
}
