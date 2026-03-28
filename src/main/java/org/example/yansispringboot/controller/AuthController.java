package org.example.yansispringboot.controller;

import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 认证控制器，处理用户登录、注册等相关请求
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public Result<String> login(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        if (username == null || password == null) {
            return Result.error("用户名和密码不能为空");
        }
        if(authService.login(username,password)){
            return Result.success();
        }
        return Result.error("账号密码错误，请重新登录");
    }
}
