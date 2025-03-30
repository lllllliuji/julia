package com.lzw.julia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    public static final boolean SUCCESS = true;

    public static final boolean ERROR = false;

    public static final int SUCCESS_CODE = 200;

    public static final int ERROR_CODE = 500;

    /**
     * 返回状态
     */
    private boolean status;

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;



    public static <T> Result<T> ok(String msg, T data) {
        return new ResultBuilder<T>().status(SUCCESS).code(SUCCESS_CODE).msg(msg).data(data).build();
    }


    public static <T> Result<T> error(String msg, T data) {
        return new ResultBuilder<T>().status(ERROR).code(ERROR_CODE).msg(msg).data(data).build();
    }

    public static <T> Result<T> error(String msg) {
        return error(msg, null);
    }

    public static <T> Result<T> error() {return error("", null);}

}
