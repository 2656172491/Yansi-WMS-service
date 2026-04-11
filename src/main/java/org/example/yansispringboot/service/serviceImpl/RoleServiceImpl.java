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
    public Role getRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }
}
