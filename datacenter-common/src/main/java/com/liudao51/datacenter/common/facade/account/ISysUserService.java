package com.liudao51.datacenter.common.facade.account;

import com.liudao51.datacenter.common.entity.account.SysUser;
import com.liudao51.datacenter.common.exception.AppException;
import com.liudao51.datacenter.common.page.PageX;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 服务类
 * </p>
 */
public interface ISysUserService {
    int insert(SysUser sysUser) throws AppException;

    int update(SysUser sysUser) throws AppException;

    int delete(SysUser sysUser) throws AppException;

    SysUser selectOne(Map<String, Object> args) throws AppException;

    List<SysUser> selectList(Map<String, Object> args) throws AppException;

    PageX<SysUser> selectPage(Map<String, Object> args, PageX page) throws AppException;
}
