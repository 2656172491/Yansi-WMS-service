package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.RoleMapper;
import org.example.yansispringboot.pojo.Role;
import org.example.yansispringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 角色服务实现类
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int deleteRole(Long id) {
        return roleMapper.deleteById(id);
    }
}
