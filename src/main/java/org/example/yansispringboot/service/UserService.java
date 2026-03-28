package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.User;

// 用户服务接口
public interface UserService {

    User login(String name, String password);

    User getUserById(Long id);

    PageResult<User> getUsers(int page, int pageSize, String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);
}
