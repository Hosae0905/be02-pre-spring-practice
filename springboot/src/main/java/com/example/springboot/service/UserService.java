package com.example.springboot.service;

import com.example.springboot.UserDao;
import com.example.springboot.model.UserLoginDto;
import com.example.springboot.model.UserSignUpDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

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

    public boolean update(String id, String pw, String newPw) {
        return userDao.update(id, pw, newPw);
    }
}
