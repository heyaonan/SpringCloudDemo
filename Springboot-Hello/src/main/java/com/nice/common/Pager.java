package com.nice.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库分页插件
 */
public class Pager {
    private static final int DEFAULT_PAGE_SIZE =10;//默认页面容量
    private int pageSize; //每页记录数
    private long totalCount;//总记录数
    private long start; //当前页的第一条记录在list中的位置，默认是0
    private List data; //每页中的数据集

    /**
     * 构造空页
     */
    public Pager(){
        this(0,DEFAULT_PAGE_SIZE,0,new ArrayList());
    }

    /**
     * 构造分页
     * @param totalCount 记录总数
     * @param pageSize 每页记录数
     * @param start 本页数据在数据库中的起始位置
     * @param data 本页包含数据集
     */
    public Pager (long totalCount,int pageSize,long start,List data){
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.start = start;
        this.data = data;
    }

    /**
     * 获取页面容量
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总记录数
     * @return
     */
    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 取总页数
     * @return
     */
    public long getTotalPageCount(){
        if(totalCount % pageSize ==0){
            return totalCount /pageSize;
        }else {
            return totalCount / pageSize +1;
        }
    }

    /**
     * 取该页当前页码,页码从0开始.
     */
    public long getCurrentPageNo() {
//		return start / pageSize + 1;
        if(pageSize == 0){
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return start / pageSize ;
    }

    /**
     * 该页是否有下一页.
     */
    public boolean isHasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount();
    }

    /**
     * 该页是否有上一页.
     */
    public boolean isHasPreviousPage() {
        return this.getCurrentPageNo() > 0;
    }

    /**
     * 获取任一页第一条数据在数据集的位置，每页条数使用默认值.
     *
     * @see #getStartOfPage(int,int)
     */
    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据在数据集的位置.
     *
     * @param pageNo   从1开始的页号
     * @param pageSize 每页记录条数
     * @return 该页第一条数据
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        return pageNo * pageSize;
    }





    /**
     * 取当前页中的数据
     * @return
     */
    public List getData() {
        return data;
    }

    /**
     * 设置当前页中的数据
     * @param data
     */
    public void setData(List data) {
        this.data = data;
    }
}
