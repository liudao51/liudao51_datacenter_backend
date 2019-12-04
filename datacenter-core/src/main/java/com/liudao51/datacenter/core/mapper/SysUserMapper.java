package com.liudao51.datacenter.core.mapper;

import com.liudao51.datacenter.core.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author jewel
 * @since 2019-07-10
 */
@Mapper
public interface SysUserMapper extends BaseMapper {

    SysUser selectOne(@Param("parameter") Map<String, Object> args);

    List<SysUser> selectList(@Param("parameter") Map<String, Object> args);
}
