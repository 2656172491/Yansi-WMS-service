package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.Role;

import java.util.List;

// 角色数据访问层
@Mapper
public interface RoleMapper {

    Role selectById(@Param("id") Long id);

    List<Role> selectAll();

    int insert(Role role);

    int update(Role role);

    int deleteById(@Param("id") Long id);
}
