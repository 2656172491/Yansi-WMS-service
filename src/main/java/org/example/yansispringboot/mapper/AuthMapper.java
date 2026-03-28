package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.User;

@Mapper
public interface AuthMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(String username, String password);
}
