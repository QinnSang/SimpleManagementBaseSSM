<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <style>
        .left{
            float: left;
        }
        .clearfix::after{
            content: ',';
            display: block;
            height: 0;
            visibility: hidden;
            clear: both;
        }
    </style>
</head>
<body>
<div>
    <div>
        <div>
            <div>
                问题：${questions.title}
            </div>
            <div>
                问题描述：${questions.detailDesc}
            </div>
        </div>
        <div class="clearfix">
            <div class="left">网友回答：</div>
            <div class="left">
                <c:forEach items="${questions.answers}" var="obj">
                    <div>
                        <div><fmt:formatDate value="${obj.ansDate}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
                        <div>${obj.ansContent}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="clearfix">
            <div class="left">我来回答:</div>
            <div class="left">
                <form action="${ctx}/answer/add" method="post">
                    <input type="hidden" name="qid" value="${questions.id}">
                    <textarea name="ansContent"></textarea>
                    <input type="submit" value="提交答案"><br>
                    <a href="${ctx}/question/main">返回首页</a>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
