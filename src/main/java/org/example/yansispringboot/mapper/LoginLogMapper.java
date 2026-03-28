package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.LoginLog;

import java.util.List;

// 登录日志数据访问层
@Mapper
public interface LoginLogMapper {

    List<LoginLog> selectPage(@Param("offset") int offset,
                              @Param("pageSize") int pageSize,
                              @Param("username") String username);

    long countByCondition(@Param("username") String username);

    int insert(LoginLog loginLog);
}
