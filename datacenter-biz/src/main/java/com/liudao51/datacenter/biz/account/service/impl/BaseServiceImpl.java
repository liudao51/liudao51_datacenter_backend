package com.liudao51.datacenter.biz.account.service.impl;

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
     * @param originArgs 原参数
     * @param withDelete 是否查询包含删除数据
     * @return
     */
    protected Map<String, Object> setBaseQueryParameter(Map<String, Object> originArgs, Boolean withDelete) {
        //删除标识
        if (!withDelete) {
            originArgs.put("deleted", 0);
        }

        return originArgs;
    }

    /**
     * 把客户端(如：Controller层)参数转换为Dao层参数
     *
     * @param args
     * @return
     */
    protected Map<String, Object> convertToQueryParameter(Map<String, Object> args, Boolean withDelete) {
        Map<String, Object> qp = new HashMap<>();

        return  qp;
    }
}
