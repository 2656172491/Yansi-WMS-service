package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.AuthMapper;
import org.example.yansispringboot.pojo.User;
import org.example.yansispringboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;
    @Override
    public boolean login(String username, String password) {
        User user = authMapper.login(username,password);
        return user != null;
    }
}
