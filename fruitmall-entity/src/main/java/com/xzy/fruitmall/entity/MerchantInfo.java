package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantInfo implements Serializable{

  private Integer merchantId;
  private String merchantAccount;
  private String merchantPass;
  private String merchantTel;

}
