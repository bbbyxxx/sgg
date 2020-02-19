package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImgInfo implements Serializable{

  private Integer imgId;
  private Integer goodsId;
  private String imgPath;
}
