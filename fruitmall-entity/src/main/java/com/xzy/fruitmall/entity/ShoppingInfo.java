package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingInfo implements Serializable{

  private Integer goodsId;
  private Integer customerId;
  private Integer goodsNum;
  //购物车中的商品的集合，一对多
  private GoodsInfo  goodsInfo;

}
