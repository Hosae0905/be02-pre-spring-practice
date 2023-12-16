package com.example.springboot.service;

import com.example.springboot.model.UserLoginDto;
import com.example.springboot.model.UserSignUpDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean login(UserLoginDto userLoginDto) {
        if (userLoginDto.getId().equals("test01") && userLoginDto.getPw().equals("qwer1234")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean signup(UserSignUpDto userSignUpDto) {
        if (userSignUpDto.getId().equals("test01")) {
            return false;
        } else {
            return true;
        }
    }
}
