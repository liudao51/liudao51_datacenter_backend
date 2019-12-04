package com.liudao51.datacenter.core.controller;

import com.liudao51.datacenter.common.annotation.RequestParamValid;
import com.liudao51.datacenter.common.constant.ErrorCode;
import com.liudao51.datacenter.common.page.PageX;
import com.liudao51.datacenter.common.util.DateX;
import com.liudao51.datacenter.common.util.StringX;
import com.liudao51.datacenter.core.entity.SysUser;
import com.liudao51.datacenter.core.exception.AppException;
import com.liudao51.datacenter.core.protocol.sys_user.*;
import com.liudao51.datacenter.core.response.ApiResponse;
import com.liudao51.datacenter.core.response.ApiResponseBody;
import com.liudao51.datacenter.core.service.ISysUserService;
import com.liudao51.datacenter.core.util.PageUtil;
import com.liudao51.datacenter.core.util.ShiroUtil;
import com.liudao51.datacenter.core.util.UidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Api(value = "系统用户相关", tags = {"系统用户相关接口"})
@RestController
@RequestMapping("/sys_user")
public class SysUserController extends BaseController {

    private ISysUserService sysUserService;

    @Autowired
    public SysUserController(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation(value = "用户新增")
    @PostMapping("/add")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<PageX<SysUser>> add(AddSysUserReq req) throws Exception {
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

        Boolean isSucceed = sysUserService.insert(sysUser);

        if (!isSucceed) {
            throw new AppException(ErrorCode.USER_ADD_ERROR.toValue(), ErrorCode.USER_ADD_ERROR.toCode());
        }

        return new ApiResponse().success();
    }

    @ApiOperation(value = "用户更新")
    @PostMapping("/update")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<PageX<SysUser>> update(UpdateSysUserReq req) throws Exception {
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

        Boolean isSucceed = sysUserService.update(sysUser);

        if (!isSucceed) {
            throw new AppException(ErrorCode.USER_UPDATE_ERROR.toValue(), ErrorCode.USER_UPDATE_ERROR.toCode());
        }

        return new ApiResponse().success();
    }

    @ApiOperation(value = "用户删除")
    @PostMapping("/delete")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody delete(DeleteSysUserReq req) throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setId(req.getId());
        sysUser.setDeleted(Byte.parseByte("1"));
        Boolean isSucceed = sysUserService.delete(sysUser);

        if (!isSucceed) {
            throw new AppException(ErrorCode.USER_DELETE_ERROR.toValue(), ErrorCode.USER_DELETE_ERROR.toCode());
        }

        return new ApiResponse().success();
    }

    @ApiOperation(value = "用户对象查询")
    @PostMapping("/get")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<SysUser> get(GetSysUserReq req) throws Exception {
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
    public ApiResponseBody<PageX<SysUser>> list(ListSysUserReq req) throws Exception {
        //设置查询参数
        Map args = new HashMap<String, Object>();
        args.put("user_name", req.getUserName());
        args.put("real_name", req.getRealName());
        args.put("mobile", req.getMobile());
        args.put("email", req.getEmail());

        //设置分页参数
        PageX page = new PageX(PageUtil.getPageNo(req.getPageNo()), PageUtil.getPageSize(req.getPageSize()));

        PageX<SysUser> sysUserList = sysUserService.selectPage(args, page);

        return new ApiResponse<PageX<SysUser>>().success(sysUserList);
    }

    @ApiOperation(value = "用户列表查询-导出")
    @PostMapping("/list/export")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody listExport(ListSysUserReq req) throws Exception {
        return new ApiResponse<PageX<SysUser>>().success();
    }

    @ApiOperation(value = "用户列表查询-下拉菜单")
    @PostMapping("/list/filter")
    @RequestParamValid
    @SuppressWarnings("unchecked")
    public ApiResponseBody<PageX<SysUser>> listFilter(ListSysUserFilterReq req) throws Exception {
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
