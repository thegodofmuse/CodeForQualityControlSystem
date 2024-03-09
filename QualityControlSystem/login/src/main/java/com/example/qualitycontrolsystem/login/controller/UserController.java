package com.example.qualitycontrolsystem.login.controller;

import com.example.qualitycontrolsystem.login.entity.login_entity.User;
import com.example.qualitycontrolsystem.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public ResponseEntity<MessageResponse> loginDirect(@RequestBody User user) {
        boolean isValid = userService.login(user.getUsername(), user.getPassword());
        if (isValid) {
            return ResponseEntity.ok().body(new MessageResponse("登录成功"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("用户名或密码错误"));
        }
    }

}
