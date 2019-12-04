package com.liudao51.datacenter.core.service.impl;

import com.liudao51.datacenter.common.page.PageX;
import com.liudao51.datacenter.common.util.StringX;
import com.liudao51.datacenter.core.dao.ISysUserDao;
import com.liudao51.datacenter.core.entity.SysUser;
import com.liudao51.datacenter.core.exception.AppException;
import com.liudao51.datacenter.core.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户服务实现类
 * </p>
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl implements ISysUserService {

    private ISysUserDao sysUserDao;

    @Autowired
    public SysUserServiceImpl(ISysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    /**
     * 把客户端Controller层参数转换为Dao层参数
     *
     * @param args
     * @return
     */
    private Map<String, Object> convertToQueryParameter(Map<String, Object> args) {
        return this.convertToQueryParameter(args, false);
    }

    private Map<String, Object> convertToQueryParameter(Map<String, Object> args, Boolean withDelete) {
        Map<String, Object> qp = new HashMap<>();

        //增加基础参数
        qp = this.setBaseQueryParameter(qp, withDelete);

        //其他查询条件
        if (!StringX.isEmpty(args.get("user_name"))) {
            qp.put("user_name", StringX.getString(args.get("user_name"), ""));
        }
        if (!StringX.isEmpty(args.get("real_name"))) {
            qp.put("real_name", StringX.getString(args.get("real_name"), ""));
        }
        if (!StringX.isEmpty(args.get("mobile"))) {
            qp.put("mobile", StringX.getString(args.get("mobile"), ""));
        }
        if (!StringX.isEmpty(args.get("email"))) {
            qp.put("email", StringX.getString(args.get("email"), ""));
        }
        if (!StringX.isEmpty(args.get("status"))) {
            qp.put("status", StringX.getString(args.get("status"), ""));
        }

        return qp;
    }

    /**
     * 增加
     *
     * @param sysUser
     * @return
     * @throws AppException
     */
    public Boolean insert(SysUser sysUser) throws AppException {
        return sysUserDao.insert(sysUser);
    }

    /**
     * 更新
     *
     * @param sysUser
     * @return
     * @throws AppException
     */
    public Boolean update(SysUser sysUser) throws AppException {
        return sysUserDao.update(sysUser);
    }

    /**
     * 删除
     *
     * @param sysUser
     * @return
     * @throws AppException
     */
    public Boolean delete(SysUser sysUser) throws AppException {
        return sysUserDao.delete(sysUser);
    }

    /**
     * 查询一行
     *
     * @param args
     * @return
     * @throws AppException
     */
    public SysUser selectOne(Map<String, Object> args) throws AppException {
        Map qp = this.convertToQueryParameter(args);

        return sysUserDao.selectOne(qp);
    }

    /**
     * 查询多行
     *
     * @param args
     * @return
     */
    public List<SysUser> selectList(Map<String, Object> args) {
        return sysUserDao.selectList(args);
    }

    /**
     * 查询多行并分页
     *
     * @param args
     * @param page
     * @return
     * @throws AppException
     */
    @SuppressWarnings("unchecked")
    public PageX<SysUser> selectPage(Map<String, Object> args, PageX page) throws AppException {
        Map qp = this.convertToQueryParameter(args);
        page = sysUserDao.selectPage(qp, page);

        return page;
    }

    /**
     * 查询多行并分页(含软删除的记录)
     *
     * @param args
     * @param page
     * @return
     * @throws AppException
     */
    @SuppressWarnings("unchecked")
    public PageX<SysUser> selectPageWithDelete(Map<String, Object> args, PageX page) throws AppException {
        Map qp = this.convertToQueryParameter(args, true);
        page = sysUserDao.selectPage(qp, page);

        return page;
    }
}
