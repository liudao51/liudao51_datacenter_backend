package com.liudao51.datacenter.core.service.impl;

import com.liudao51.datacenter.core.util.PageUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * class: 服务实现基类
 * <p>
 * Created by jewel on 2019/8/9.
 */
public abstract class BaseServiceImpl {
    /**
     * 把Map参数转换为QueryParameter(数据库查询条件的参数名)
     *
     * @param args
     * @return
     */
    protected Map<String,Object> convertToQueryParameter(Map args) {
        return this.convertToQueryParameter(args, false);
    }

    protected Map<String,Object> convertToQueryParameter(Map args, Boolean withDelete) {
        Map<String,Object> qw = new HashMap<String, Object>();
        //删除标识
        if (!withDelete) {
            qw.put("deleted", 0);
        }
        return qw;
    }

    /**
     * 设置分页参数查询
     *
     * @param queryParameter
     * @param pageNo
     * @param pageSize
     * @return
     */
    protected Map<String,Object> setPageQueryParameter(Map<String,Object> queryParameter, Object pageNo, Object pageSize) {
        queryParameter.put("page_no", PageUtil.getPageNo(pageNo));
        queryParameter.put("page_size", PageUtil.getPageNo(pageSize));

        return queryParameter;
    }
}
