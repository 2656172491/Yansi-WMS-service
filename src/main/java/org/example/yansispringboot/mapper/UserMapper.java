package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.User;

import java.util.List;

// 用户数据访问层
@Mapper
public interface UserMapper {

    User selectById(@Param("id") Long id);

    User selectByName(@Param("name") String name);

    List<User> selectPage(@Param("offset") int offset,
                          @Param("pageSize") int pageSize,
                          @Param("name") String name);

    long countByCondition(@Param("name") String name);

    int insert(User user);

    int update(User user);

    int deleteById(@Param("id") Long id);
}
