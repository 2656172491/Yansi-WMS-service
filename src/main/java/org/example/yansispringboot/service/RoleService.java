package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.Role;

import java.util.List;

// 角色服务接口
public interface RoleService {

    Role getRoleById(Long id);

    List<Role> getRoles();

    int addRole(Role role);

    int updateRole(Role role);

    int deleteRole(Long id);
}
