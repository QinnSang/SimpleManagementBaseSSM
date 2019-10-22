<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/21
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${ctx}/comments/add" method="post">
        <input type="hidden" name="newsDetail.id" value="${newid}">
        <table border="1">
            <thead>
                <tr>
                    <th colspan="2">增加评论</th>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td>评论内容</td>
                <td>
                    <textarea name="content" rows="10" cols="40"></textarea>
                </td>
            </tr>
            <tr>
                <td>评论人</td>
                <td>
                    <input type="text" name="author">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                    <a href="javascript:history.go(-1)">返回</a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
