package com.liudao51.datacenter.biz.account.dao;

import com.liudao51.datacenter.common.entity.account.SysUser;
import com.liudao51.datacenter.common.page.PageX;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * interface:
 * <p>
 * Created by jewel on 2019/7/15.
 */
@Component
public interface ISysUserDao extends IBaseDao {
    int insert(SysUser sysUser);

    int update(SysUser sysUser);

    int delete(SysUser sysUser);

    SysUser selectOne(Map args);

    List<SysUser> selectList(Map args);

    PageX<SysUser> selectListPage(Map args, PageX page);
}
