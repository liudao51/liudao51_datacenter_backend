package com.liudao51.datacenter.biz.account.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liudao51.datacenter.biz.account.dao.ISysUserDao;
import com.liudao51.datacenter.biz.account.mapper.SysUserMapper;
import com.liudao51.datacenter.common.entity.account.SysUser;
import com.liudao51.datacenter.common.page.PageX;
import com.liudao51.datacenter.common.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * class: 用户数据访问类
 * <p>
 */
@Primary
@Component
public class SysUserDaoImpl extends BaseDaoImpl implements ISysUserDao {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 增加
     *
     * @param sysUser
     * @return
     */
    public int insert(SysUser sysUser) {
        return 0;
    }

    /**
     * 更新
     *
     * @param sysUser
     * @return
     */
    public int update(SysUser sysUser) {
        return 0;
    }

    /**
     * 删除
     *
     * @param sysUser
     * @return
     */
    public int delete(SysUser sysUser) {
        return 0;
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
     * 查询多行不分页
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
    public PageX<SysUser> selectListPage(Map args, PageX page) {
        //插入PageHelper插件代码
        PageHelper.startPage(page.getPageNo(), page.getPageSize(), true);

        //如果不使用分页插件,可以在这里根据page_no,page_size计算并补全分页参数limit的start,end
        //...

        List<SysUser> list = sysUserMapper.selectList(args);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);

        return PageUtil.pageInfoToPage(pageInfo);
    }
}
