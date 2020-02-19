package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponInfo implements Serializable{

  private Integer couponId;
  private Integer customerId;
  private Double couponValue;
  private String couponTime;
  private String couponDeadline;
  private Integer couponState;
}
