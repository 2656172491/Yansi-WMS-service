package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.yansispringboot.pojo.LoginLog;

// 登录日志数据访问层
@Mapper
public interface LoginLogMapper {

    @Insert("insert into loginlog ( username, status, ip, message, createTime) " +
            "values (#{username}, #{status}, #{ip}, #{message}, now())")
    void add(LoginLog loginLog);
}
