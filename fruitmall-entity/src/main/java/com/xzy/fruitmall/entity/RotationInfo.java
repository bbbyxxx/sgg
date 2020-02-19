package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RotationInfo implements Serializable{

  private Integer rotationId;
  private String imgPath;
  private Integer goodsId;


}
