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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${ctx}/entry/modify" method="post">
        <input type="hidden" name="edocCategory.id" value="${entry.edocCategory.id}">
        <input type="hidden" name="id" value="${entry.id}">
        <table border="1">
            <thead>
                <tr>
                    <th colspan="2">修改电子文档</th>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td>文档编号</td>
                <td>
                    ${entry.id}
                </td>
            </tr>
            <tr>
                <td>文档名称</td>
                <td>
                    <input type="text" name="title" value="${entry.title}"/>
                </td>
            </tr>
            <tr>
                <td>文档摘要</td>
                <td>
                    <textarea name="summary" rows="10" cols="40">${entry.summary}</textarea>
                </td>
            </tr>
            <tr>
                <td>上传人</td>
                <td>
                    <input type="text" name="uploadUser" value="${entry.uploadUser}">
                </td>
            </tr>
            <tr>
                <td>上传时间</td>
                <td>
                    <input type="text" name="createdate" value="<fmt:formatDate value="${entry.createdate}" pattern="yyyy-MM-dd"/>">
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
