package com.example.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpDto {
    private String id;
    private String pw;
    private String name;
}
