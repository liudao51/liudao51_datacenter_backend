package com.liudao51.datacenter.web.controller;

import com.liudao51.datacenter.common.constant.ErrorCode;
import com.liudao51.datacenter.common.entity.account.SysUser;
import com.liudao51.datacenter.common.exception.AppException;
import com.liudao51.datacenter.common.facade.account.ISysUserService;
import com.liudao51.datacenter.common.page.PageX;
import com.liudao51.datacenter.common.util.DateX;
import com.liudao51.datacenter.common.util.PageUtil;
import com.liudao51.datacenter.common.util.StringX;
import com.liudao51.datacenter.web.annotation.RequestParamValid;
import com.liudao51.datacenter.web.protocol.sys_user.*;
import com.liudao51.datacenter.web.response.ApiResponse;
import com.liudao51.datacenter.web.response.ApiResponseBody;
import com.liudao51.datacenter.web.util.ShiroUtil;
import com.liudao51.datacenter.web.util.UidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Api(value = "系统用户", tags = {"系统用户"})
@RestController
@RequestMapping("/sys_user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value = "用户新增")
    @PostMapping("/add")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<PageX<SysUser>> add(@RequestBody AddSysUserReq req) throws Exception {
        Date date = DateX.getDate();
        Long dateTime = date.getTime();
        String handler = "admin";
        Long id = UidUtil.getUid();
        String salt = ShiroUtil.getRandomSalt();

        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setUserName(req.getUserName());
        sysUser.setPassword(ShiroUtil.encryptPassword(req.getPassword(), salt));
        sysUser.setSalt(salt);
        sysUser.setRealName(req.getRealName());
        sysUser.setMobile(req.getMobile());
        sysUser.setEmail(req.getEmail());
        sysUser.setDepartmentId(req.getDepartmentId());
        sysUser.setDepartmentName(req.getDepartmentName());
        sysUser.setStatus(Byte.parseByte("1"));
        sysUser.setRemark(req.getRemark());
        sysUser.setCreatedBy(handler);
        sysUser.setCreatedTime(dateTime);
        sysUser.setUpdatedBy(handler);
        sysUser.setUpdatedTime(dateTime);
        sysUser.setDeleted(Byte.parseByte("0"));

        int affectedRows = sysUserService.insert(sysUser);

        if (affectedRows == 0) {
            throw new AppException(ErrorCode.USER_ADD_ERROR.toValue(), ErrorCode.USER_ADD_ERROR.toCode());
        }

        return new ApiResponse().success();
    }

    @ApiOperation(value = "用户更新")
    @PostMapping("/update")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<PageX<SysUser>> update(@RequestBody UpdateSysUserReq req) throws Exception {
        Date date = DateX.getDate();
        Long dateTime = date.getTime();
        Long id = req.getId();
        String handler = "admin";
        String salt = ShiroUtil.getRandomSalt();

        SysUser sysUser = new SysUser();
        sysUser.setId(id);

        //如果密码没有填写,则使用之前的密码
        if (!StringX.isEmpty(req.getPassword())) {
            sysUser.setPassword(ShiroUtil.encryptPassword(req.getPassword(), salt));
            sysUser.setSalt(salt);
        }

        sysUser.setRealName(req.getRealName());
        sysUser.setMobile(req.getMobile());
        sysUser.setEmail(req.getEmail());
        sysUser.setDepartmentId(req.getDepartmentId());
        sysUser.setDepartmentName(req.getDepartmentName());
        sysUser.setRemark(req.getRemark());
        sysUser.setCreatedBy(handler);
        sysUser.setCreatedTime(dateTime);
        sysUser.setUpdatedBy(handler);
        sysUser.setUpdatedTime(dateTime);

        int affectedRows = sysUserService.update(sysUser);

        if (affectedRows == 0) {
            throw new AppException(ErrorCode.USER_UPDATE_ERROR.toValue(), ErrorCode.USER_UPDATE_ERROR.toCode());
        }

        return new ApiResponse().success();
    }

    @ApiOperation(value = "用户删除")
    @PostMapping("/delete")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody delete(@RequestBody DeleteSysUserReq req) throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setId(req.getId());
        sysUser.setDeleted(Byte.parseByte("1"));

        int affectedRows = sysUserService.delete(sysUser);

        if (affectedRows == 0) {
            throw new AppException(ErrorCode.USER_DELETE_ERROR.toValue(), ErrorCode.USER_DELETE_ERROR.toCode());
        }

        return new ApiResponse().success();
    }

    @ApiOperation(value = "用户对象查询")
    @PostMapping("/get")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<SysUser> get(@RequestBody GetSysUserReq req) throws Exception {
        //设置查询参数
        Map args = new HashMap<String, Object>();
        args.put("user_name", req.getUserName());
        args.put("real_name", req.getRealName());
        args.put("mobile", req.getMobile());
        args.put("email", req.getEmail());

        SysUser sysUser = sysUserService.selectOne(args);

        return new ApiResponse<SysUser>().success(sysUser);
    }

    @ApiOperation(value = "用户列表查询")
    @PostMapping("/list")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<PageX<SysUser>> list(@RequestBody ListSysUserReq req) throws Exception {
        //设置查询参数
        Map args = new HashMap<String, Object>();
        args.put("user_name", req.getUserName());
        args.put("real_name", req.getRealName());
        args.put("mobile", req.getMobile());
        args.put("email", req.getEmail());

        //设置分页参数
        PageX page = new PageX(PageUtil.getPageNo(req.getPageNo(), 1), PageUtil.getPageSize(req.getPageSize(), 10));

        PageX<SysUser> sysUserList = sysUserService.selectPage(args, page);

        return new ApiResponse<PageX<SysUser>>().success(sysUserList);
    }

    @ApiOperation(value = "用户列表查询-导出")
    @PostMapping("/list/export")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody listExport(@RequestBody ListSysUserReq req) throws Exception {
        return new ApiResponse<PageX<SysUser>>().success();
    }

    @ApiOperation(value = "用户列表查询-下拉菜单")
    @PostMapping("/list/filter")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<PageX<SysUser>> listFilter(@RequestBody ListSysUserFilterReq req) throws Exception {
        //设置查询参数
        Map args = new HashMap<String, Object>();
        args.put("user_name", req.getUserName());
        args.put("real_name", req.getRealName());
        args.put("email", req.getEmail());

        //设置分页参数
        PageX page = new PageX(PageUtil.getPageNo(req.getPageNo()), PageUtil.getPageNo(req.getPageSize()));

        PageX<SysUser> sysUserListPage = sysUserService.selectPage(args, page);

        return new ApiResponse<PageX<SysUser>>().success(sysUserListPage);
    }
}
