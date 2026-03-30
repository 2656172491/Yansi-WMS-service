package org.example.yansispringboot;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import org.example.yansispringboot.mapper.StatisticsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootTest
class YansiSpringbootApplicationTests {

    @Autowired
    private StatisticsMapper statisticsMapper;

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

    @Test
    void trendTest(){
        List<Map<String, Object>> list = statisticsMapper.getInventoryTrends(6);
        // 2. 把查询结果转成 Map，方便按日期快速取值
        Map<String, Map<String, Object>> dataMap = new HashMap<>();
        for (Map<String, Object> item : list) {
            dataMap.put(String.valueOf(item.get("date")), item);
        }
        // 3. 准备最近 7 天日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        List<String> dates = new ArrayList<>();
        List<Integer> inbound = new ArrayList<>();
        List<Integer> outbound = new ArrayList<>();

        LocalDate start = LocalDate.now().minusDays(6);
        for (int i = 0; i < 7; i++) {
            LocalDate current = start.plusDays(i);
            String dateStr = current.format(formatter);
            dates.add(dateStr);

            Map<String, Object> item = dataMap.get(dateStr);
            if (item != null) {
                inbound.add(((Number) item.getOrDefault("in_quantity", 0)).intValue());
                outbound.add(((Number) item.getOrDefault("out_quantity", 0)).intValue());
            } else {
                inbound.add(0);
                outbound.add(0);
            }
        }
        System.out.println("日期: " + dates);
        System.out.println("入库数量: " + inbound);
        System.out.println("出库数量: " + outbound);
    }

}
