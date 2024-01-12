package com.liuji.julia.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;

    private String msg;

    private Object data;

    private Object errDetail;

    public static Result ok() {
        return new Result(HttpStatus.OK.value(), HttpStatus.OK.name(), null, null);
    }

    public static Result error() {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), null, null);
    }

    public static Result error(HttpStatus status) {
        return new Result(status.value(), status.name(), null, null);
    }

    public Result data(Object data) {
        this.data = data;
        return this;
    }

    public Result errDetail(Object errDetail) {
        this.errDetail = errDetail;
        return this;
    }
}
