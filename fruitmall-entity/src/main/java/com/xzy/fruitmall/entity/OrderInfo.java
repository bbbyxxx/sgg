package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo implements Serializable{
  private Integer orderId;
  private Integer customerId;
  private Integer merchantId;
  private Double orderAmount;
  private String orderTime;
  private Integer addressId;
  private String orderState;
  private String paymentMethod;
  //一对多，订单中的商品的集合
  private Set<GoodsInfo> goodsOrderSet;
  //地址实体，记录该订单的收货地址
  private AddressInfo addressInfo;

  private String orderDescription;
}
