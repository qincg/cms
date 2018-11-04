package bean;

import java.io.Serializable;
import java.util.List;

/**
 * 此方法用于分页
 */
public class PageBean<T> implements Serializable {

    /**
     * 每页显示多少条数据
     */
    private int pageSize;

    /**
     * 总共有多少数据
     */
    private int totalSize;

    /**
     * 总页数
     */
    private int totalPage;


    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 存放数据的list
     */
    private List<T> list;

    /**
     * 显示在页面上的开始页码
     */
    private int start;

    /**
     * 显示在页面上的结束页码
     */
    private int end;

    public PageBean(int pageSize, int totalSize, int currentPage) {
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        // 总页数可以根据总数+一页显示数量计算出来
        if (totalSize % pageSize == 0) {
            this.totalPage = totalSize / pageSize;
        } else {
            this.totalPage = totalSize / pageSize + 1;
        }
        this.currentPage = currentPage;
        this.start = 1;
        this.end = 5;
        // start,end 的计算方法，最好页面显示页码数为奇数，则currentPage - start和end - currentPage的值相等
        // 如果显示页码数为5，当前页为7，则start = 5,end = 9
        // 如果显示页码数为7，当前页为7，则start = 4,end = 10
        if (totalPage <= end) {
            // 如果总页数小于end，则end为当前页
            this.end = currentPage;
        } else {
            // 总页数大于5，根据当前页显示start，end
            // 正常情况下,start,end 的值
            this.start = currentPage - 2;
            this.end = currentPage + 2;
            // 对start，end修正
            if (start <= 0) {
                this.start = 1;
                this.end = 5;
            }
            if (end > totalPage) {
                this.end = totalPage;
                // 最后几条的页码数显示都是一致的
                this.start = end - 5;
            }
        }

    }

    public PageBean() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
