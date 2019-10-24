<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>title</title>
    <style>
        table tbody tr:nth-of-type(even){
            background-color: lightblue;
        }
        table thead tr{
            background-color:aquamarine;
        }
    </style>
</head>
<body>

<div>
    <h1>在线问答</h1>
    <a href="${ctx}/question/addTo">我要提问</a>

    <table>
        <thead>
            <tr>
                <th>序号</th>
                <th>问题</th>
                <th>回答次数</th>
                <th>最后修改时间</th>
            </tr>
        </thead>
        <tbody>

            <c:forEach items="${questions}" var="obj" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td><a href="${ctx}/question/query/answer/${obj.id}"   <c:if test="${obj.answerCount eq 0}">
                        style="color:red"
                    </c:if>>${obj.title}</a></td>
                    <td>${obj.answerCount}</td>
                    <td><fmt:formatDate value="${obj.lastModified}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div
</body>
</html>
