package com.liudao51.datacenter.common.util;

import com.github.pagehelper.PageInfo;
import com.liudao51.datacenter.common.page.PageX;

import java.util.List;

/**
 * 分页工具类
 */
public class PageUtil {
    private static final Integer DEFAULT_PAGE_NO = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    @SuppressWarnings("unchecked")
    public static Integer getPageNo(Object val) {
        return (NumericX.isNumeric(val, NumericX.NUMERIC_TYPE_INTEGER) && Integer.valueOf(val.toString()) > 0) ?
                Integer.valueOf(val.toString()) : DEFAULT_PAGE_NO;
    }

    @SuppressWarnings("unchecked")
    public static Integer getPageNo(Object val, Integer defaultPageNo) {
        return (NumericX.isNumeric(val, NumericX.NUMERIC_TYPE_INTEGER) && Integer.valueOf(val.toString()) > 0) ?
                Integer.valueOf(val.toString()) : defaultPageNo;
    }

    @SuppressWarnings("unchecked")
    public static Integer getPageSize(Object val) {
        return (NumericX.isNumeric(val, NumericX.NUMERIC_TYPE_INTEGER) && Integer.valueOf(val.toString()) > 0) ?
                Integer.valueOf(val.toString()) : DEFAULT_PAGE_SIZE;
    }

    @SuppressWarnings("unchecked")
    public static Integer getPageSize(Object val, Integer defaultPageSize) {
        return (NumericX.isNumeric(val, NumericX.NUMERIC_TYPE_INTEGER) && Integer.valueOf(val.toString()) > 0) ?
                Integer.valueOf(val.toString()) : defaultPageSize;
    }

    @SuppressWarnings("unchecked")
    public static PageX recordToPage(List records, Integer pageNo, Integer PageSize, Integer total) {
        return new PageX(pageNo, PageSize, total, records);
    }

    @SuppressWarnings("unchecked")
    public static PageX pageInfoToPage(PageInfo pageInfo) {
        return new PageX(pageInfo.getPageNum(), pageInfo.getPageSize(), Long.valueOf(pageInfo.getTotal()).intValue(), pageInfo.getList());
    }
}