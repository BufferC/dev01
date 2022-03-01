package com.fc.vo;

import java.util.List;

// 分页信息类，包含了所有分页的相关参数
public class PageInfo<T> {
    // 当前页
    private int pageNo;
    // 每页显示多少条内容
    private int pageSize;
    // 总页数
    private int pageCount;
    // 总数据量
    private int totalCount;
    // 每页的所有数据
    private List<T> list;

    public PageInfo() {
    }

    public PageInfo(int pageNo, int pageSize, int totalCount, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;

        if (totalCount % pageSize == 0) {
            this.pageCount = totalCount / pageSize;
        } else {
            this.pageCount = totalCount / pageSize + 1;
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
