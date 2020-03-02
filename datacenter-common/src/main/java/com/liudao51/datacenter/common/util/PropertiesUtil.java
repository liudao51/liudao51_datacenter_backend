package com.liudao51.datacenter.common.util;

import com.liudao51.datacenter.common.constant.ErrorCode;
import com.liudao51.datacenter.common.exception.AppException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * class: 读取资源文件的配置工具类
 */
public class PropertiesUtil {
    /**
     * 通过指定资源文件名获取资源对象
     *
     * @param location
     * @return
     */
    public static Properties getLocationProperties(String location) {
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(new ClassPathResource(location), "UTF-8"));

        } catch (IOException ioe) {
            throw new AppException(ErrorCode.SYSTEM_RESOURCES_IO_ERROR.toValue(), ErrorCode.SYSTEM_RESOURCES_IO_ERROR.toCode());
        }

        return properties;
    }

    /**
     * 通过默认资源文件名(application.properties)获取资源对象
     *
     * @return
     */
    public static Properties getDefaultProperties() {
        String profilesActive = (PropertiesUtil.getLocationProperties("application.properties")).getProperty("spring.profiles.active");
        String location = (profilesActive != null && profilesActive != "") ? "application-" + profilesActive + ".properties" : "application.properties";

        return PropertiesUtil.getLocationProperties(location);
    }

}
