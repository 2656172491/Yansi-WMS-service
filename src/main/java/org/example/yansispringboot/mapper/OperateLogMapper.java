package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.OperateLog;

import java.util.List;

// 操作日志数据访问层
@Mapper
public interface OperateLogMapper {

    List<OperateLog> selectPage(@Param("offset") int offset,
                                @Param("pageSize") int pageSize,
                                @Param("username") String username);

    long countByCondition(@Param("username") String username);

    int insert(OperateLog operateLog);
}
