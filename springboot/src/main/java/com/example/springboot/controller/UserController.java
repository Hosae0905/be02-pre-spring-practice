package com.example.springboot.controller;

import com.example.springboot.model.UserSignUpDto;
import com.example.springboot.service.UserService;
import com.example.springboot.model.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 생성자로 의존성 주입하는 방법
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto) {
        if(userService.login(userLoginDto)) {
            return ResponseEntity.ok().body("로그인 성공");
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody UserSignUpDto userSignUpDto) {
        if (userService.signup(userSignUpDto)) {
            return ResponseEntity.ok().body("로그인 성공");
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity<Object> update(String id, String pw, String newPw) {
        if(userService.update(id, pw, newPw)) {
            return ResponseEntity.ok().body("수정 성공");
        } else {
            return ResponseEntity.badRequest().body("수정 실패");
        }
    }
}
