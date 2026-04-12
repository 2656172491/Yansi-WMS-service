package org.example.yansispringboot.controller;

import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Role;
import org.example.yansispringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping
    public Result<Void> addRole(@RequestBody Role role){
        roleService.addRole(role);
        return Result.success();
    }

    @PutMapping("/{id}")
    public Result<Void> updateRole(@RequestBody Role role){
        roleService.updateRole(role);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteRole(@PathVariable Integer id){
        roleService.deleteRole(id);
        return Result.success();
    }

    @GetMapping("/stats")
    public Result<Map<String, Object>> getRoleStats() {
        Map<String, Object> stats = Map.of(
                "total", roleService.getAllRoles().size(),
                "enabled", roleService.getAllRoles().stream().filter(r -> r.getStatus() == 1).count(),
                "highPermission", roleService.getAllRoles().stream().filter(r -> r.getLevel() >= 3).count(),
                "normal", roleService.getAllRoles().stream().filter(r -> r.getLevel() == 2).count()
        );
        return Result.success(stats);
    }
}
