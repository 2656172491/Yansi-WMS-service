package org.example.yansispringboot;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YansiSpringbootApplicationTests {

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Test
    void JWTTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZWFsTmFtZSI6IueuoeeQhuWRmCIsInJvbGUiOiJBRE1JTiIsInVzZXJuYW1lIjoiYWRtaW4ifQ.4OMOOA0wXPNLvW-bToFTj7i9_cjcp7me1O_TPMxWD_w";
        System.out.println(JWTUtil.verify(token, jwtSecret.getBytes()));

        JWT parseJWT = JWTUtil.parseToken(token);
        JWTPayload payload = parseJWT.getPayload();
        String username = payload.getClaim("username").toString();
        System.out.println(username);
    }

}
