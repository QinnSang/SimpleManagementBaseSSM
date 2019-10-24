<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <h1>我要提问</h1>
        <a href="${ctx}/question/main">返回首页</a>
        <form action="${ctx}/question/add" method="post">
            问题：<input type="tex" name="title"><br>
            问题描述：<textarea name="detailDesc"></textarea><br>
            <input type="submit" value="保存问题">
        </form>
    </div>
</body>
</html>
