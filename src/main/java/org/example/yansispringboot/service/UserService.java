package org.example.yansispringboot.service;


import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.User;

import java.util.List;

// 用户服务接口
public interface UserService {
    PageResult getAllUsers(String username,
                           String roleId,
                           Integer status,
                           Integer pageNum,
                           Integer pageSize
    );

    User getUserById(long id);

    void addUser(User user);

    void updateUser(User user);

    List<User> getAllUsers(String o, String o1, Integer o2);
}
