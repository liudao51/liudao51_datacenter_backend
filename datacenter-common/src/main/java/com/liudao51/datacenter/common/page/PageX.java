package com.liudao51.datacenter.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义分页对象
 */
public class PageX<T> implements Serializable {
    //已知数据
    private Integer pageNo;  //当前页
    private Integer pageSize;  //每页显示条数
    private Integer totalRecord;  //总记录条数
    private List<T> records;  //将每页要显示的数据放在list集合中

    //需要计算得来
    private Integer totalPage; //总页数
    private Integer prePage; //前一页
    private Integer nextPage; //后一页
    private Integer startIndex; //记录索引开始位置（在数据库中要从第几行数据开始拿）

    public PageX(Integer pageNo, Integer pageSize) {
        this.init(pageNo, pageSize, 0);
    }

    public PageX(Integer pageNo, Integer pageSize, Integer totalRecord) {
        this.init(pageNo, pageSize, totalRecord);
    }

    public PageX(Integer pageNo, Integer pageSize, Integer totalRecord, List<T> records) {
        this.init(pageNo, pageSize, totalRecord);
        this.setRecords(records);
    }

    private void init(Integer pageNo, Integer pageSize, Integer totalRecord) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //总页数
        this.totalPage = (totalRecord % pageSize == 0) ? (totalRecord / pageSize) : (totalRecord / pageSize + 1);

        //前一页
        this.prePage = (pageNo - 1) > 1 ? (pageNo - 1) : 1;

        //后一页
        this.nextPage = (pageNo + 1) < totalRecord ? pageNo + 1 : totalRecord;

        //记录索引开始位置
        this.startIndex = (pageNo - 1) * pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}