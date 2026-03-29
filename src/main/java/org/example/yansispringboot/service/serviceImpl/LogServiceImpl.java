package org.example.yansispringboot.service.serviceImpl;

import cn.hutool.jwt.JWTUtil;
import org.example.yansispringboot.mapper.LoginLogMapper;
import org.example.yansispringboot.mapper.OperateLogMapper;
import org.example.yansispringboot.pojo.LoginLog;
import org.example.yansispringboot.pojo.OperateLog;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 日志服务实现类
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public void userLog(String token, int status, String ip, String message) {
        String username = JWTUtil.parseToken(token).getPayload().getClaim("username").toString();
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setStatus(status);
        loginLog.setIp(ip);
        loginLog.setMessage(message);
        loginLogMapper.add(loginLog);
    }

    @Override
    public void actionLog(String token, String type,String module, String content, String ip) {
        // 解析JWT令牌，获取用户名
        String username = JWTUtil.parseToken(token).getPayload().getClaim("username").toString();
        OperateLog operateLog = new OperateLog();
        operateLog.setUsername(username);
        operateLog.setType(type);
        operateLog.setModule(module);
        operateLog.setContent(content);
        operateLog.setIp(ip);
        operateLogMapper.addLog(operateLog);
    }

    @Override
    public List<Map<String, String>> getRecentActivities() {
        List<Map<String,Object>> list = operateLogMapper.getRecentActivities();
        List<Map<String, String>> lastList = new ArrayList<>();
        for(Map<String,Object> item : list){
            System.out.println(item);
            Map<String,String> map = new HashMap<>();
            map.put("id", item.get("id").toString());
            map.put("content", "用户：" + item.get("username").toString() + "," + item.get("content").toString());
            map.put("time", item.get("create_time").toString());
            lastList.add(map);
        }
        System.out.println(lastList);
        return lastList;
    }
}
