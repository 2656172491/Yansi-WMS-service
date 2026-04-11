package org.example.yansispringboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public PageResult getAllUsers(String username,
                                  String roleId,
                                  Integer status,
                                  Integer pageNum,
                                  Integer pageSize
    ) {
        PageResult<User> pageResult = new PageResult<>();
        PageHelper.startPage(pageNum, pageSize);

        List<User> userList = userMapper.getAllUsers(username,roleId,status);
        Page<User> page = (Page<User>) userList;

        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        return pageResult;
    }

    @Override
    public User getUserById(long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> getAllUsers(String o, String o1, Integer o2) {
        return userMapper.getAllUsers(o,o1,o2);
    }
}
