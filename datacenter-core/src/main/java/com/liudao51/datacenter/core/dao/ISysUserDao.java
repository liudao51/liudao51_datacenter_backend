package com.liudao51.datacenter.core.dao;

import com.liudao51.datacenter.common.page.PageX;
import com.liudao51.datacenter.core.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * interface:
 * <p>
 * Created by jewel on 2019/7/15.
 */
public interface ISysUserDao extends IBaseDao {
    Boolean insert(SysUser sysUser);

    Boolean update(SysUser sysUser);

    Boolean delete(SysUser sysUser);

    SysUser selectOne(Map args);

    List<SysUser> selectList(Map args);

    PageX<SysUser> selectPage(Map args, PageX page);
}
