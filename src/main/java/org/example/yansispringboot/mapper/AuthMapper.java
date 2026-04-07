package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.User;

@Mapper
public interface AuthMapper {
    /**
     * 用户登录验证
     * @param username 用户名
     * @param password 密码
     * @return 用户信息，如果登录成功；否则返回null
     */
    @Select("select * from user " +
            "where username = #{username} and password = #{password}")
    User login(String username, String password);

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息，如果用户存在；否则返回null
     */
    @Select("select * from user " +
            "where username = #{username}")
    User getUserInfo(String username);
}
