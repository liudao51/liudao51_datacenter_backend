package com.liudao51.datacenter.core.util;

import com.liudao51.datacenter.common.page.Pager;
import com.liudao51.datacenter.common.util.StringX;

import java.util.List;

/**
 * 分页工具类
 */
public class PageUtil {
    private static final Long DEFAULT_PAGE_NO = 1L;
    private static final Long DEFAULT_PAGE_SIZE = 10L;

    public static Pager recordToPager(List records, Long pageNo, Long PageSize, Long total) {
        return new Pager(pageNo, PageSize, total, records);
    }

    public static Long getPageNo(Object val) {
        Long pageNo = 1L;

        if (!StringX.isEmpty(val)) {
            try {
                pageNo = Long.valueOf(StringX.getString(val, "1"));
                pageNo = (pageNo > 0) ? pageNo : DEFAULT_PAGE_NO;
            } catch (Exception e) {
                pageNo = DEFAULT_PAGE_NO;
            }
        }

        return pageNo;
    }

    public static Long getPageSize(Object val) {
        Long pageSize = 1L;

        if (!StringX.isEmpty(val)) {
            try {
                pageSize = Long.valueOf(StringX.getString(val, "1"));
                pageSize = (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE;
            } catch (Exception e) {
                pageSize = DEFAULT_PAGE_SIZE;
            }
        }

        return pageSize;
    }
}