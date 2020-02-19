package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadPortraitInfo implements Serializable{

  private String headPortrait;
  private Integer headPortraitId;

}
