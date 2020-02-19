package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo implements Serializable{

  private Integer evaluateId;
  private String responser;
  private String responseContent;
  private String responseTime;

}
