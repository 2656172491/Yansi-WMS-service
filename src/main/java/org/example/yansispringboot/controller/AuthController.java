package org.example.yansispringboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.User;
import org.example.yansispringboot.service.AuthService;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param username 用户名
     * @param password 密码
     * @param request  请求对象，用于获取用户IP地址等信息
     * @return token   JWT令牌
     */
    @PostMapping("/login")
    public Result<String> login(String username, String password, HttpServletRequest request) {
        log.info("用户登录请求，用户名：{}", username);
        log.info("用户的登录ip地址：{}", request.getRemoteAddr());
        if (username == null || password == null) {
            logService.userLog(username,1,request.getRemoteAddr(),"登录失败,用户名或密码为空");
            return Result.error("用户名和密码不能为空");
        }
        if(authService.login(username,password)){
            logService.userLog(username,0,request.getRemoteAddr(),"登录成功");
            String token = "11";
            return Result.success(token);
        }
        logService.userLog(username,1,request.getRemoteAddr(),"登录失败,用户名或密码错误");
        return Result.error("账号密码错误，请重新登录");
    }

    /**
     * 登出请求
     * @param username  用户名
     * @param request 请求对象，用于获取用户IP地址等信息
     * @return string 成功退出
     */
    @PostMapping("/logout")
    public Result<String> logout(String username, HttpServletRequest request){
        log.info("用户登出请求,用户名:{}",username);
        logService.userLog(username,0,request.getRemoteAddr(),"用户登出");
        return Result.success("成功退出");
    }

    /**
     * 获取用户信息
     * @param username 用户名
     * @param request 请求对象，用于获取用户IP地址等信息
     * @return User 用户信息
     */
    @GetMapping("/me")
    public Result<User> getUserInfo(@RequestParam String username,@RequestParam String module, HttpServletRequest request){
        log.info("获取用户信息请求,用户名:{}",username);
        User user = authService.getUserInfo(username);
        logService.actionLog(username,"获取用户信息",module,"获取用户信息成功",request.getRemoteAddr());
        return Result.success(user);
    }

    /**
     * 刷新token
     * @return 新token
     */
    @PostMapping("/refresh")
    public Result<String> refresh(){
        String token = "11";
        return Result.success(token);
    }
}
