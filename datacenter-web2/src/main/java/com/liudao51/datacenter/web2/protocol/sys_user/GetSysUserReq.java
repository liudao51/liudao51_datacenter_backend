package com.liudao51.datacenter.web2.protocol.sys_user;

import com.liudao51.datacenter.web2.protocol.ParamValidInterface;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.oval.constraint.Digits;
import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.Length;

@ApiModel(value = "GetSysUserReq")
@Data
public class GetSysUserReq implements ParamValidInterface {

    @ApiModelProperty(value = "用户名", example = "", required = false)
    private String userName;

    @ApiModelProperty(value = "真实姓名", example = "", required = false)
    private String realName;

    @Digits(message = "手机格式不正确")
    @Length(min = 10, max = 13, message = "手机长度不正确")
    @ApiModelProperty(value = "手机", example = "", required = false)
    private String mobile;

    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱", example = "", required = false)
    private String email;
}
