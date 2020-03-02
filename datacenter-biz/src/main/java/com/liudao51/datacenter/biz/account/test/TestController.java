package com.liudao51.datacenter.biz.account.test;

import com.liudao51.datacenter.common.entity.account.SysUser;
import com.liudao51.datacenter.common.facade.account.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * class:
 * <p>
 * Created by jewel on 2020/3/31.
 */
@RestController
@RequestMapping("/account")
public class TestController {

    @Autowired
    ISysUserService sysUserService;

    @ApiOperation(value = "用户对象查询")
    @PostMapping("/get")
    @SuppressWarnings("unchecked")
    public String get() throws Exception {
        //设置查询参数
        Map args = new HashMap<String, Object>();
        args.put("user_name", "admin");

        SysUser sysUser = sysUserService.selectOne(args);

        return sysUser.toString();
    }
}
