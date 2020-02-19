package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayInfo implements Serializable{

  private Integer displayId;
  private Integer goodsId;
  //一个商品实体，记录展示的商品的信息
  private GoodsInfo displayGoodsInfo;
}
