package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdverInfo implements Serializable{

  private Integer adverId;
  private String adverTitle;
  private String adverImgPath;
  private String adverLinks;
}
