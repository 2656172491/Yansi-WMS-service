package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.Role;

import java.util.List;

// 角色数据访问层
@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM role WHERE id = #{id}")
    Role getRoleById(Integer id);

    @Select("SELECT * FROM role")
    List<Role> getAllRoles();
}
