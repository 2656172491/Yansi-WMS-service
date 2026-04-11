package org.example.yansispringboot.controller;

import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Role;
import org.example.yansispringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 角色管理控制器，处理与角色相关的请求，如获取角色列表、创建角色等
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public Result<Role> getRoleById(@PathVariable Integer id){
        Role role = roleService.getRoleById(id);
        return Result.success(role);
    }

    @GetMapping
    public Result<List<Role>> getAllRole(){
        List<Role> roles = roleService.getAllRoles();
        return Result.success(roles);
    }
}
