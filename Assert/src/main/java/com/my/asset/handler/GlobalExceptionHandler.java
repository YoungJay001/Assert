package com.my.asset.handler;

import com.my.asset.Bean.Result;
import com.my.asset.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex) {
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(400, ex.getMessage());
    }


    /**
     * 处理连接超时异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(ConnectException ex) {
        log.error("连接超时异常：{}", ex.getMessage());
        return Result.error(500, "连接超时，请稍后重试");
    }

}
