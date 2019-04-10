package com.itheima.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {

    // 当前页码
    private int pageNumber;
    // 每页显示条数
    private int pageSize;
    // 总条数
    private int total;
    //总页数
    private int totalPage;
    // 当前页的 数据
    private List<T> data = new ArrayList<>();

    public PageBean() {
    }

    public PageBean(int pageNumber, int pageSize, int total, int pageTotal,
                    List<T> data) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.totalPage = totalPage;
        this.data = data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
               "pageNumber=" + pageNumber +
               ", pageSize=" + pageSize +
               ", total=" + total +
               ", totalPage=" + totalPage +
               ", data=" + data +
               '}';
    }
}
