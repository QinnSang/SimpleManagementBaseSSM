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
    <form action="${ctx}/category/query/categoryId" method="post">
        <span>分类文档：</span>
        <select name="id">
            <option value="0">全部</option>
            <c:forEach items="${categories}" var="obj">
                <option value="${obj.id}" <c:if test="${categoryId eq obj.id}">
                    selected </c:if>>
                        ${obj.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="查询">
        <%--<a href="${ctx}/entry/addTo">新增电子文档</a>--%>
        <input type="button" id="addBtn" value="新增电子文档">
    </form>
</div>
<div>
    <table border="1">
        <thead>
            <tr><th colspan="6">
                <h2>电子文档列表</h2>
            </th></tr>
            <tr>
                <th>文档编号</th>
                <th>文档名称</th>
                <th>文档摘要</th>
                <th>上传人</th>
                <th>上传时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${entries}" var="obj">
            <tr>
                <td>${obj.id}</td>
                <td>${obj.title}</td>
                <td>${obj.summary}</td>
                <td>${obj.uploadUser}</td>
                <td><fmt:formatDate value="${obj.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <%--使用restful风格：查询 评论模块  根据新闻id查询 新闻id是--%>
                    <a href="${ctx}/entry/modifyTo/${obj.id}">修改</a>
                    <a href="${ctx}/entry/delete/${obj.id}">删除</a>
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#addBtn").click(function () {
            //获取当前分类
            var id=$('form select').val();
            if(id==0){
                alert("请选择分类信息");
                return false;
            }
            window.location ="${ctx}/entry/addTo/"+id;
        })
    })
</script>
</body>
</html>
