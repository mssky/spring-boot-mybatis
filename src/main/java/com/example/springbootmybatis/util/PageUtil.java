package com.example.springbootmybatis.util;

/**
 * Created by lhp on 17/9/12.
 */
public class PageUtil {
    public static Integer getCurrentPage(Integer currentPage) {
        currentPage = currentPage == null ? 1 : currentPage < 1 ? 1 : currentPage;
        return currentPage;
    }

    public static Integer getPageSize(Integer pageSize) {
        pageSize = pageSize == null ? 10 : pageSize;
        return pageSize;
    }

}
