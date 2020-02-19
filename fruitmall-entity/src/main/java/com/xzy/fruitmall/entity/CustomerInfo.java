package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo implements Serializable{

  private Integer customerId;
  private String customerAccount;
  private String customerPass;
  private String customerTel;
  private String nickName;
  private Integer headPortraitId;
  private String customerSex;
  private Integer powerId;
  private String regTime;
  private Integer orderNumber;
  private Integer consumptionAmount;
  private Integer loginTimes;
  //一对一，头像表
  private HeadPortraitInfo headPortraitInfo;
  /*//一个收藏表集合，里面封装了该用户的收藏的商品的集合一对一
  //一个收藏表集合，里面封装了该用户的收藏的商品的集合一对一
  private Set<CollectionInfo> collectionSet;
  //客户的收货地址集合，一对多
  private Set<AddressInfo> addressSet;
  //客户的历史浏览记录集合，一对多
  private Set<AddressInfo> historySet;
  //客户的评价集合，记录他有过哪些评价,一对多
  private Set<EvaluateInfo> evaluateSet;
  //客户订单集合，一对多
  private Set<OrderInfo> orderSet;*/
}
