package com.liudao51.datacenter.core.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liudao51.datacenter.common.page.PageX;
import com.liudao51.datacenter.core.dao.ISysUserDao;
import com.liudao51.datacenter.core.entity.SysUser;
import com.liudao51.datacenter.core.mapper.SysUserMapper;
import com.liudao51.datacenter.core.util.PageUtil;
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

    private SysUserMapper sysUserMapper;

    @Autowired
    public SysUserDaoImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 增加
     *
     * @param sysUser
     * @return
     */
    public Boolean insert(SysUser sysUser) {
        return true;
    }

    /**
     * 更新
     *
     * @param sysUser
     * @return
     */
    public Boolean update(SysUser sysUser) {
        return true;
    }

    /**
     * 删除
     *
     * @param sysUser
     * @return
     */
    public Boolean delete(SysUser sysUser) {
        return true;
    }

    /**
     * 查询一行
     *
     * @param args
     * @return
     */
    public SysUser selectOne(Map args) {
        return sysUserMapper.selectOne(args);
    }

    /**
     * 查询多行
     *
     * @param args
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SysUser> selectList(Map args) {
        return sysUserMapper.selectList(args);
    }

    /**
     * 查询多行并分页
     *
     * @param args
     * @param page
     * @return
     */
    @SuppressWarnings("unchecked")
    public PageX<SysUser> selectPage(Map args, PageX page) {
        //插入PageHelper插件代码
        PageHelper.startPage(page.getPageNo(), page.getPageSize(), true);

        //如果不使用分页插件,可以在这里根据page_no,page_size计算并补全分页参数limit的start,end

        List<SysUser> list = sysUserMapper.selectList(args);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);

        return PageUtil.pageInfoToPage(pageInfo);
    }
}
