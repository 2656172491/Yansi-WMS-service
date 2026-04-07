package org.example.yansispringboot.service.serviceImpl;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import org.example.yansispringboot.mapper.AuthMapper;
import org.example.yansispringboot.pojo.User;
import org.example.yansispringboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Override
    public String login(String username, String password) {
        User user = authMapper.login(username,password);
        if(user != null){
            User userInfo = authMapper.getUserInfo(username);
            // 生成JWT令牌，包含用户信息和权限
            // 创建JWT头部
            Map<String, Object> header = new HashMap<>();
            header.put("alg","HS256");
            header.put("typ","JWT");

            // 创建JWT负载，包含用户信息和权限
            Map<String,Object> payload = new HashMap<>();
            payload.put("username",userInfo.getUsername());
            payload.put("realName",userInfo.getRealName());
            payload.put("role",userInfo.getRoleId());
            payload.put("id",userInfo.getId());

            // 使用HMAC SHA256算法和密钥生成JWT令牌
            String token = JWTUtil.createToken(header, payload, jwtSecret.getBytes(StandardCharsets.UTF_8));
            return token;
        }
        return null;
    }

    @Override
    public User getUserInfo(String token) {
        // 解析JWT令牌，获取用户信息和权限
        JWT parseJWT = JWTUtil.parseToken(token);
        JWTPayload payload = parseJWT.getPayload();
        String username = (String) payload.getClaim("username");
        return authMapper.getUserInfo(username);
    }
}
