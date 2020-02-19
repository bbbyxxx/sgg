package com.xzy.fruitmall.controller;

import com.xzy.fruitmall.biz.CollectionService;
import com.xzy.fruitmall.entity.CollectionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgg")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    @GetMapping(value = {"/findCollectionById/{customerId}"})
    public List<CollectionInfo> findCollectionById(@PathVariable("customerId") int customerId){
        return collectionService.findCollectionById(customerId);
    }

    @PostMapping(value = {"/collectGoods/{customerId}/{goodsId}"})
    public String collectGoods(CollectionInfo collection){
        boolean bool = true;
        CollectionInfo c = collectionService.isCollectted(collection);//查询是否有该商品
        if(c==null){
            bool = collectionService.collectGoods(collection);
        }else {
            return null;
        }
        String code,msg;
        if(bool){
            code="1";
            msg="\"添加收藏成功！\"";
        }else{
            code="0";
            msg="\"添加收藏失败！\"";
        }
        String status="{\"code\":"+code+",\"msg\":"+msg+"}";
        return status;
    }

    @DeleteMapping(value = {"/deleteCollection/{customerId}/{goodsId}"})
    public String deleteCollection(CollectionInfo collection){
        boolean bool = collectionService.delectCollection(collection);
        String code,msg;
        if(bool){
            code="1";
            msg="\"删除收藏成功！\"";
        }else{
            code="0";
            msg="\"删除收藏失败！\"";
        }
        String status="{\"code\":"+code+",\"msg\":"+msg+"}";
        return status;
    }

}
