package com.swj.Test.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class UserInfoDto {
  private String email;
  private String password;
  private String auth;
  
}