package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadlineInfo implements Serializable{

  private Integer headlineId;
  private String headlineTitle;
  private String headlineContent;
}
