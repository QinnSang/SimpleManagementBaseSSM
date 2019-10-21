<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/20
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <style>
        table tbody tr:nth-of-type(2n+1){
            background-color: lightblue;
        }
    </style>
</head>
<body>
<div>
    <form action="${ctx}/news/queryNewsByName" method="post">
        <span>新闻标题：</span><input type="text" name="title">
        <input type="submit" value="查询">
    </form>

</div>
<div>
    <table border="1">
        <thead>
            <tr><th colspan="6">
                <h2>新闻标题</h2>
            </th></tr>
            <tr>
                <th>新闻编号</th>
                <th>新闻标题</th>
                <th>新闻摘要</th>
                <th>作者</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${news}" var="obj">
            <tr>
                <td>${obj.id}</td>
                <td>${obj.title}</td>
                <td>${obj.summary}</td>
                <td>${obj.author}</td>
                <td><fmt:formatDate value="${obj.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <%--使用restful风格：查询 评论模块  根据新闻id查询 新闻id是--%>
                    <a href="${ctx}/comments/query/newsid/${obj.id}">查看评论</a>
                    <a href="${ctx}/comments/addTo/${obj.id}">评论</a>
                    <a href="${ctx}/news/delete/${obj.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6">
                <c:if test="${deleteFlag eq true}">
                    <span style="color: red">删除成功</span>
                </c:if>
                <c:if test="${deleteFlag eq false}">
                    <span style="color: red">删除失败</span>
                </c:if>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
