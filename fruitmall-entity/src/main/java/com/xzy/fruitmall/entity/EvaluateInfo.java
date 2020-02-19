package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateInfo implements Serializable{

  private Integer evaluateId;
  private Integer customerId;
  private Integer goodsId;
  private String evaluateContent;
  private String evaluateTime;
  private Integer responseState;//商品评论信息回复的集合，一对多
  private Set<ResponseInfo> responseSet;
}
