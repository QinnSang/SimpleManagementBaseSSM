<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/21
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table border="1">
        <thead>
        <tr><th colspan="4">
            <h2>评论列表 <a href="${ctx}">返回新闻列表</a> </h2>
        </th></tr>
        <tr>
            <th>评论编号</th>
            <th>评论内容</th>
            <th>评论人</th>
            <th>评论时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${comments}" var="obj">
            <tr>
                <td>${obj.id}</td>
                <td>${obj.content}</td>
                <td>${obj.author}</td>
                <td><fmt:formatDate value="${obj.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
