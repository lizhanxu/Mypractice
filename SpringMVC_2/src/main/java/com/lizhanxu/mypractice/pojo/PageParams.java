package com.lizhanxu.mypractice.pojo;

/**
 * @ClassName PageParams
 * @Description
 * @Date 2019/10/29
 * @Created by lizhanxu
 */
public class PageParams {

    //当前页码
    private int start;

    //每页大小
    private int limit;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "PageParams{" +
                "start=" + start +
                ", limit=" + limit +
                '}';
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
