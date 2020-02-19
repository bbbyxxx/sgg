package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOrderInfo implements Serializable{

  private Integer orderId;
  private Integer goodsId;
  private Integer goodsNum;
  private GoodsInfo goodsInfo;
}
