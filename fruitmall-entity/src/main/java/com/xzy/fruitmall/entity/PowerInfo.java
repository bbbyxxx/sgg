package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerInfo implements Serializable{

  private Integer powerId;
  private Double discountRate;
  private String powerDescription;

}
