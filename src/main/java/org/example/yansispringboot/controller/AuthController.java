package org.example.yansispringboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.service.AuthService;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 认证控制器，处理用户登录、注册等相关请求
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private LogService logService;

    /**
     * 登录请求
     * @param username
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result<String> login(String username, String password, HttpServletRequest request) {
        log.info("用户登录请求，用户名：{}", username);
        log.info("用户的登录ip地址：{}", request.getRemoteAddr());
        if (username == null || password == null) {
            logService.log(username,1,request.getRemoteAddr(),"登录失败,用户名或密码为空");
            return Result.error("用户名和密码不能为空");
        }
        if(authService.login(username,password)){
            logService.log(username,0,request.getRemoteAddr(),"登录成功");
            return Result.success();
        }
        logService.log(username,1,request.getRemoteAddr(),"登录失败,用户名或密码错误");
        return Result.error("账号密码错误，请重新登录");
    }
}
