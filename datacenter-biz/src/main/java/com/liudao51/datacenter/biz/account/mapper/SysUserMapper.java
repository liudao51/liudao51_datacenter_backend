package com.liudao51.datacenter.biz.account.mapper;

import com.liudao51.datacenter.common.entity.account.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * class: 用户 Mapper 接口
 * </p>
 */
@Mapper
@Repository
public interface SysUserMapper {

    SysUser selectOne(@Param("parameter") Map<String, Object> args);

    List<SysUser> selectList(@Param("parameter") Map<String, Object> args);
}





