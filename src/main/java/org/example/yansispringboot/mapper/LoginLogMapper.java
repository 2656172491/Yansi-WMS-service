package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.yansispringboot.pojo.LoginLog;

// 登录日志数据访问层
@Mapper
public interface LoginLogMapper {

    @Insert("insert into login_log(user_id, username, status, ip, message, user_agent) " +
            "values(#{userId}, #{username}, #{status}, #{ip}, #{message}, #{userAgent})")
    void add(LoginLog loginLog);
}
