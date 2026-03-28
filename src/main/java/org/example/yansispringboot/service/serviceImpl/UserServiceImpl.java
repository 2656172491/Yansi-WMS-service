package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.UserMapper;
import org.example.yansispringboot.pojo.User;
import org.example.yansispringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 用户服务实现类
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String password) {
        User user = userMapper.selectByName(name);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public PageResult<User> getUsers(int page, int pageSize, String name) {
        int offset = (page - 1) * pageSize;
        List<User> records = userMapper.selectPage(offset, pageSize, name);
        long total = userMapper.countByCondition(name);
        return new PageResult<>(total, records);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteById(id);
    }
}
