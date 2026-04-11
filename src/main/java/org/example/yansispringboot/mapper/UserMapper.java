package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.User;


// 用户数据访问层
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByName(String username);
}
