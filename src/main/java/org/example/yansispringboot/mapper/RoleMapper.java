package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.*;
import org.example.yansispringboot.pojo.Role;

import java.util.List;

// 角色数据访问层
@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM role WHERE id = #{id}")
    Role getRoleById(Integer id);

    @Select("SELECT * FROM role")
    List<Role> getAllRoles();

    @Insert("insert into role (role_name, role_code, level, status, create_time, update_time) " +
            "value (#{roleName}, #{roleCode}, #{level}, #{status}, NOW(), NOW())")
    void addRole(Role role);

    @Update("update role set role_name = #{roleName}, role_code = #{roleCode}, level = #{level}, " +
            "status = #{status}, update_time = NOW() where id = #{id}")
    void updateRole(Role role);

    @Delete("delete from role where id = #{id}")
    void deleteRole(Integer id);
}
