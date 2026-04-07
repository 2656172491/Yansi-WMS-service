package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.yansispringboot.pojo.LoginLog;

// 登录日志数据访问层
@Mapper
public interface LoginLogMapper {

    /**
     * 记录登录日志
     * @param loginLog 登录日志对象，包含用户ID、用户名、登录状态、IP地址、消息和用户代理信息
     */
    @Insert("insert into login_log(user_id, username, status, ip, message, user_agent, create_time)" +
            "values(#{userId}, #{username}, #{status}, #{ip}, #{message}, #{userAgent},NOW())")
    void add(LoginLog loginLog);
}
