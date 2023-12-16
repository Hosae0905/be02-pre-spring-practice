package com.example.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {     // 데이터를 주고받는 용도로만 사용한다.
    private String id;
    private String pw;
}
