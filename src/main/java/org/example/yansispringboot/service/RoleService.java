package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.Role;

import java.util.List;

// 角色服务接口
public interface RoleService {

    Role getRoleById(Integer id);

    List<Role> getAllRoles();

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Integer id);
}
