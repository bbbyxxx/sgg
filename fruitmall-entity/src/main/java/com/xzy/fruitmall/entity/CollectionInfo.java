package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionInfo implements Serializable{

  private Integer goodsId;
  private Integer customerId;
  private GoodsInfo goodsInfo;
}
