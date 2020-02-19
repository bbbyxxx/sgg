package com.xzy.fruitmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInfo implements Serializable{

  private Integer id;
  private String cityId;
  private String city;
  private String provinceId;

}
