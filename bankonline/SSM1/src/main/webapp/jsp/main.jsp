<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <style>
    .left{
      float:left;
    }
    .clearfix::after{
      content:'.';
      height:0;
      display:block;;
      visibility:hidden;
      clear:both;
    }
  </style>
</head>
<body>
<div>
  卡号：${sessionScope.account.cardNo}<a href="${ctx}/account/logout">退出登录</a>
</div>
<div class="left">
  <div><a href="${ctx}/account/balance/${sessionScope.account.id}">查询余额</a></div>
  <div><a href="${ctx}/account/transferTo">转账</a></div>
  <div><a href="${ctx}/transaction/recordTo">查询交易记录</a></div>
  <div><a href="">修改密码</a></div>
</div>
<div class="left">
  <c:if test="${page eq 'balance'}">
    <jsp:include page="balance.jsp"/>
  </c:if>
  <c:if test="${page eq 'transfer'}">
    <jsp:include page="transfer.jsp"/>
  </c:if>
  <c:if test="${page eq 'record'}">
    <jsp:include page="record.jsp"/>
  </c:if>
</div>
</body>
</html>
