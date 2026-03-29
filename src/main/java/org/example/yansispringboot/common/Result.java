package org.example.yansispringboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;//业务状态码  0-成功  1-失败
    private String message;//提示信息
    private T data;//响应数据


    //快速返回操作成功响应结果(带响应数据)
    // 成功：带数据
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    // 成功：无数据
    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功", null);
    }

    // 失败
    public static <T> Result<T> error(String message) {
        return new Result<>(400, message, null);
    }

}
