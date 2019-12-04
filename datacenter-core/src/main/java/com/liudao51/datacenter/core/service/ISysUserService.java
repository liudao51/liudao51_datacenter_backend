package com.liudao51.datacenter.core.service;

import com.liudao51.datacenter.common.page.PageX;
import com.liudao51.datacenter.core.entity.SysUser;
import com.liudao51.datacenter.core.exception.AppException;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 服务类
 * </p>
 */
public interface ISysUserService extends IBaseService {
    Boolean insert(SysUser sysUser) throws AppException;

    Boolean update(SysUser sysUser) throws AppException;

    Boolean delete(SysUser sysUser) throws AppException;

    SysUser selectOne(Map<String, Object> args) throws AppException;

    List<SysUser> selectList(Map<String, Object> args) throws AppException;

    PageX<SysUser> selectPage(Map<String, Object> args, PageX page) throws AppException;
}
