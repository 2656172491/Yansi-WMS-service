package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.UserMapper;
import org.example.yansispringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 用户服务实现类
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

}
