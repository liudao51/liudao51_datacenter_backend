package com.liudao51.datacenter.core.dao.impl;

import com.liudao51.datacenter.core.dao.ISysUserDao;
import com.liudao51.datacenter.core.entity.SysUser;
import com.liudao51.datacenter.core.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * class:
 * <p>
 * Created by jewel on 2019/7/15.
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl implements ISysUserDao {
    @Autowired
    SysUserMapper sysUserMapper;

    public Boolean insert(SysUser sysUser) {
        return true;
    }

    public Boolean update(SysUser sysUser) {
        return true;
    }

    public Boolean delete(SysUser sysUser) {
        return true;
    }

    public SysUser selectOne(Map args) {
        return sysUserMapper.selectOne(args);
    }

    public List<SysUser> selectList(Map args) {
        return sysUserMapper.selectList(args);
    }

    public List<SysUser> selectListPage(Map args) {
        return sysUserMapper.selectList(args);
    }
}
