package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryInfo implements Serializable{

  private Integer historyId;
  private Integer customerId;
  private Integer goodsId;
  private String browseTime;
  //一个goodsInfo的实体，表示该条历史记录对应的实体类，一对一
  private GoodsInfo goodsInfo;

}
