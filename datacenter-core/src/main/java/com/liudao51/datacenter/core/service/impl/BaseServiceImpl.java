package com.liudao51.datacenter.core.service.impl;

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
}
