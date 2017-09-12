<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<c:if test="${result.pages>1}">
    <div id="paging" style="text-align: center;"></div>
</c:if>

<script type="text/javascript">
    showPaging();

    function formSubmit(currentPage) {

        $("#currentPage").val(currentPage);

        $('#paramSelectForm').submit();
    }

    function showPaging() {
        var pagingStr = '';
        pagingStr += '<ul class="pagination">';

        var currentPage = ${currentPage};


        if (currentPage <= 1) {
            pagingStr += '<li class="prev disabled"><a href="javascript:void(0);">上一页</a></li>';
        } else {
            pagingStr += '<li class="prev"><a href="javascript:void(0);" onclick="formSubmit(${currentPage - 1})">上一页</a></li>';
        }

        if (currentPage == 5) {
            pagingStr += '<li><a href="javascript:void(0);" onclick="formSubmit(1)">1</a></li>';
        }

        if (currentPage >= 6) {
            pagingStr += '<li><a href="javascript:void(0);" onclick="formSubmit(1)">1</a></li>';
            pagingStr += '<li><a>…</a></li>';
        }

        for (var i = (currentPage - 3 < 1 ? 1 : currentPage - 3); i <= currentPage; i++) {
            if (i == currentPage) {
                pagingStr += '<li class="active" ><a href="javascript:void(0);" onclick="formSubmit(' + i + ')">' + i + '</a></li>';
            } else {
                pagingStr += '<li ><a href="javascript:void(0);" onclick="formSubmit(' + i + ')">' + i + '</a></li>';
            }
        }

        for (var j = currentPage + 1; j <= (currentPage + 2 > ${result.pages} ? ${result.pages} : currentPage + 2); j++) {
            pagingStr += '<li ><a href="javascript:void(0);" onclick="formSubmit(' + j + ')">' + j + '</a></li>';
        }

        if (currentPage >= ${result.pages}) {
            pagingStr += '<li class="next disabled"><a href="javascript:void(0);">下一页</a></li>';
        } else if (currentPage + 2 >= ${result.pages}) {
            pagingStr += '<li class="next"><a href="javascript:void(0);" onclick="formSubmit(${currentPage + 1})">下一页</a></li>';
        } else if (currentPage + 3 == ${result.pages}) {
            pagingStr += '<li><a href="javascript:void(0);" onclick="formSubmit(${result.pages})">${result.pages}</a></li>';
            pagingStr += '<li class="next"><a href="javascript:void(0);" onclick="formSubmit(${currentPage + 1})">下一页</a></li>';
        } else {
            pagingStr += '<li><a>…</a></li>';
            pagingStr += '<li><a href="javascript:void(0);" onclick="formSubmit(${result.pages})">${result.pages}</a></li>';
            pagingStr += '<li class="next"><a href="javascript:void(0);" onclick="formSubmit(${currentPage + 1})">下一页</a></li>';
        }

        <%--
        for (var i = (currentPage-4 <1? 1 : currentPage-4); i <= currentPage; i++) {
            if (i == currentPage) {
                pagingStr += '<li class="active" ><a href="javascript:void(0);" onclick="formSubmit('+i+')">' + i +'</a></li>';
            } else {
                pagingStr += '<li ><a href="javascript:void(0);" onclick="formSubmit('+i+')">' + i + '</a></li>';
            }
        }

        for (var j = currentPage+1; j <= (currentPage + 5 > ${pages} ? ${pages} :  currentPage + 5); j++) {
            pagingStr += '<li ><a href="javascript:void(0);" onclick="formSubmit('+j+')">' + j + '</a></li>';
        }

        if (currentPage >= ${pages}) {
            pagingStr += '<li class="next disabled"><a href="javascript:void(0);">下一页</a></li>';
        } else {
            pagingStr += '<li class="next"><a href="javascript:void(0);" onclick="formSubmit(${currentPage + 1})">下一页</a></li>';
        }
        --%>
        pagingStr += '</ul>';
        $("#paging").html(pagingStr);

    }

</script>

