package org.example.yansispringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.User;
import org.example.yansispringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

// 用户管理控制器，处理用户相关的请求，如获取用户信息、更新用户资料等
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result<PageResult> getAllUsers(
            String username,
            String roleId,
            Integer status,
            Integer pageNum,
            Integer pageSize
    ){
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        PageResult pageResult = userService.getAllUsers(username,roleId,status,pageNum,pageSize);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
        if(user != null){
            return Result.success(user);
        } else {
            return Result.error("用户不存在");
        }
    }

    @PostMapping
    public Result<Void> addUser(@RequestBody User user){
        log.info(String.valueOf(user));
        userService.addUser(user);
        return Result.success();
    }

    @PutMapping
    public Result<Void> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable long id){
        User user = userService.getUserById(id);
        if(user != null){
            user.setIsDeleted(1); // 逻辑删除
            userService.updateUser(user);
            return Result.success();
        } else {
            return Result.error("用户不存在");
        }
    }

    @PutMapping("/upStatus/{id}")
    public Result<Void> updateUserStatus(
            @PathVariable long id,
            // 接收一个对象，不要直接接收 int
            @RequestBody Map<String, Integer> body
    ) {
        User user = userService.getUserById(id);
        if (user == null) {
            return Result.error("用户不存在");
        }

        // 从对象里拿 status
        int status = body.get("status");
        user.setStatus(status);
        userService.updateUser(user);
        return Result.success();
    }

    @GetMapping("/stats")
    public Result<Map<String,Object>> getUserStats(){
        List<User> users = userService.getAllUsers(null,null,null);
        long totalUsers = users.size();
        long activeUsers = users.stream().filter(u -> u.getStatus() == 1).count();
        long keeperUsers = users.stream().filter(u -> Objects.equals(u.getRoleId(), "2")).count();  // 仓管员
        long adminUsers = users.stream().filter(u -> Objects.equals(u.getRoleId(), "3")).count();   // 管理员

        Map<String, Object> stats = Map.of(
                "total", totalUsers,
                "enabled", activeUsers,
                "storekeeper", keeperUsers,
                "admin", adminUsers
        );
        return Result.success(stats);
    }
}
