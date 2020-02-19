package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInfo implements Serializable {

  private Integer addressId;
  private Integer customerId;
  private String consignee;
  private String consigneeAddress;
  private String consigneeTel;
  private Integer isDefault;
}
