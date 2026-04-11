package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.yansispringboot.pojo.User;

import java.util.List;


// 用户数据访问层
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByName(String username);
    List<User> getAllUsers(String username,
                           String roleId,
                           Integer status);
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(long id);

    @Insert("insert into user(username, password, real_name, employee_no, email, avatar, phone, role_id, status, create_time,update_time,is_deleted) " +
            "value (#{username}, #{password}, #{realName}, #{employeeNo}, #{email}, #{avatar}, #{phone}, #{roleId}, #{status}, NOW(), NOW(),#{isDeleted})")
    void addUser(User user);

    @Update("update user set username=#{username}, password=#{password}, real_name=#{realName}, employee_no=#{employeeNo}, email=#{email}, avatar=#{avatar}, phone=#{phone}, role_id=#{roleId}, status=#{status}, update_time=NOW(), is_deleted=#{isDeleted} where id=#{id}")
    void updateUser(User user);
}
