package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo implements Serializable{

  private Integer goodsId;
  private String goodsName;
  private Double goodsPrice;
  private String goodsSort;
  private String goodsDescription;
  private Integer goodsStock;
  private Integer goodsThreshold;
  private String goodsOrigin;
  private String storageConditions;
  private String goodsBrand;
  private Integer goodsSale;
  private Integer goodsClick;
  private String picPath;
  private String goodsTime;
  //商品图片的集合，一对多
  private Set<ImgInfo> imgSet;
  //商品评论的集合，一对多
  private Set<EvaluateInfo> evaluateSet;
}
