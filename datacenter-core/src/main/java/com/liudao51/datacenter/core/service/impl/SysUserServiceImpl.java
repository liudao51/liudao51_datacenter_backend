package com.liudao51.datacenter.core.service.impl;

import com.liudao51.datacenter.common.page.Pager;
import com.liudao51.datacenter.common.util.StringX;
import com.liudao51.datacenter.core.dao.ISysUserDao;
import com.liudao51.datacenter.core.entity.SysUser;
import com.liudao51.datacenter.core.service.ISysUserService;
import com.liudao51.datacenter.core.util.PageUtil;
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

    @Autowired
    private ISysUserDao sysUserDao;

    @Override
    protected Map<String, Object> convertToQueryParameter(Map args, Boolean withDelete) {
        Map<String, Object> qp = new HashMap<String, Object>();
        //删除标识
        if (!withDelete) {
            qp.put("deleted", 0);
        }

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

    public Boolean add(SysUser sysUser) {
        return sysUserDao.insert(sysUser);
    }

    public Boolean update(SysUser sysUser) {
        return sysUserDao.update(sysUser);
    }

    public Boolean delete(SysUser sysUser) {
        return sysUserDao.delete(sysUser);
    }

    public SysUser selectOne(Map args) {
        Map qp = this.convertToQueryParameter(args);

        return sysUserDao.selectOne(qp);
    }

    public List<SysUser> selectList(Map args) {
        return sysUserDao.selectList(args);
    }

    @SuppressWarnings("unchecked")
    public Pager<SysUser> selectListPage(Map args) {
        Map qp = this.convertToQueryParameter(args);
        qp = this.setPageQueryParameter(qp, args.get("page_no"), args.get("page_size"));
        List<SysUser> records = sysUserDao.selectListPage(qp);

        return PageUtil.recordToPager(records, 1L, 10L, 10L);
    }
}
