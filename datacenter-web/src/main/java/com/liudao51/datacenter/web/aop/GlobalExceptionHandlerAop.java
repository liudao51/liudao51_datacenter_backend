package com.liudao51.datacenter.web.aop;

import com.liudao51.datacenter.common.exception.AppException;
import com.liudao51.datacenter.web.response.ApiResponse;
import com.liudao51.datacenter.web.response.ApiResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 加强版Controller: 全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerAop {
    /**
     * 自定义异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(AppException.class)
    public ApiResponseBody exceptionHandle(HttpServletRequest request, AppException ex) throws Exception {
        ex.setIp(request.getRemoteAddr());
        ex.setUrl(request.getRequestURL().toString());
        ex.setParams(request.getParameterMap());

        return new ApiResponse().fail(ex);
    }

    /**
     * 系统异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ApiResponseBody exceptionHandle(HttpServletRequest request, Exception ex) {
        AppException ex2 = new AppException(ex); //把Exception转换为AppException
        ex2.setIp(request.getRemoteAddr());
        ex2.setUrl(request.getRequestURL().toString());
        ex2.setParams(request.getParameterMap());

        return new ApiResponse().fail(ex2);
    }
}
