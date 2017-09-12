/**
 * Created by lhp on 17/4/25.
 */
$(function () {
    /**
     * 搜索按钮点击事件
     */
    $('#searchBtn').click(function () {
        $('#searchForm').submit();
    });

    /**
     * 点击页码翻页
     */
    $('.pageItem').click(function () {
        var currentPageInputObj = $('#currentPage');
        currentPageInputObj.val($(this).text().trim());
        $('#searchForm').append(currentPageInputObj).submit();
    });

    /**
     * 向前翻页
     */
    $('.previous').click(function () {
        if ($(this).hasClass('disabled')) {
            return;
        }
        var currentPageInputObj = $('#currentPage');
        var currentPage = currentPageInputObj.val();
        currentPage = parseInt(currentPage);
        currentPageInputObj.val(currentPage - 1);
        $('#searchForm').append(currentPageInputObj).submit();
    });

    /**
     * 向后翻页
     */
    $('.next').click(function () {
        if ($(this).hasClass('disabled')) {
            return;
        }
        var currentPageInputObj = $('#currentPage');
        var currentPage = currentPageInputObj.val();
        currentPage = parseInt(currentPage);
        currentPageInputObj.val(currentPage + 1);
        $('#searchForm').append(currentPageInputObj).submit();
    });

    /**
     * 首页、尾页
     */
    $('.first, .last').click(function () {
        var currentPageInputObj = $('#currentPage');
        currentPageInputObj.val($(this).attr("value").trim());
        $('#searchForm').append(currentPageInputObj).submit();
    });

})
