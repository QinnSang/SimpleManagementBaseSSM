<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<form action="${ctx}/transaction/queryTransaction" method="post">
    <h2>查询交易记录</h2>
    <input type="hidden" name="cardNo" value="${sessionScope.account.cardNo}">
    <input type="hidden" name="pageSize" value="5">
    <input type="hidden" name="pageNum" value="1">
    查询日期范围：<input type="datetime-local" name="start">到：<input type="datetime-local" name="end">
    <input type="submit" value="查询">
    <table>
        <thead>
        <tr>
            <th>交易日期</th>
            <th>交易额</th>
            <th>账户余额</th>
            <th>交易类型</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageInfo.list}" var="obj">
                <tr>
                    <td><fmt:formatDate value="${obj.transactionDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${obj.transactionAmount}</td>
                    <td>${obj.balance}</td>
                    <td>${obj.transactionType}</td>
                    <td>${obj.remark}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <a data-for="page-first" href="javascript:void(0)">首页</a>|
                    <a data-for="page-pre" href="javascript:void(0)">上一页</a>|
                    <a data-for="page-next" href="javascript:void(0)">下一页</a>|
                    <a data-for="page-last" href="javascript:void(0)">末页</a>|
                    第${pageInfo.pageNum}页/共${pageInfo.pages}页(共${pageInfo.total}条记录)
                </td>
            </tr>
        </tbody>
    </table>
</form>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script>
    $(function () {
        $('a[data-for^=page]').click(function () {
            var val=$(this).attr('data-for');
            var pageNum='${pageInfo.pageNum}'
            switch (val) {
                case 'page-first':
                    pageNum=1;
                    break;
                case 'page-pre':
                    pageNum=pageNum-1;
                    break;
                case 'page-next':
                    pageNum=pageNum+1;
                    break;
                case 'page-last':
                    pageNum='${pageInfo.pages}';
                    break;
            }
            $('input[name=pageNum]').val(pageNum);
            $('form').submit();
        })
    })
</script>