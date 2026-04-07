package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.OperateLog;

import java.util.List;
import java.util.Map;


// 操作日志数据访问层
@Mapper
public interface OperateLogMapper {

    /**
     * 添加操作日志
     * @param operateLog 操作日志对象，包含用户ID、用户名、操作类型、模块、内容和IP地址等信息
     */
    @Insert("insert into operate_log(user_id,username,type,module,content,ip,create_time) " +
            "values(#{userId},#{username},#{type},#{module},#{content},#{ip},NOW())")
    void addLog(OperateLog operateLog);

    /**
     * 获取最近的操作日志记录，主要用于展示用户的近期活动
     * @return 一个包含操作日志信息的列表，每条记录包含ID、用户名、内容、类型和创建时间等字段
     */
    @Select("select id,username,content,type,create_time from operate_log")
    List<Map<String, Object>> getRecentActivities();
}
