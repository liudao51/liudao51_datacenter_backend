package com.liudao51.datacenter.core.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * class:
 * <p>
 * Created by jewel on 2019/8/5.
 */
public abstract class BaseController {
    /**
     * 得到request对象
     *
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
