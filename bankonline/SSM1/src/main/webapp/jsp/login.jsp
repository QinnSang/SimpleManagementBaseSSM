<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/22
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>title</title>
    <style>
        #main{
            width: 80%;
            margin: auto;
            background-color: lightblue;
        }
        form{
            width: 30%;
            margin:auto;
        }
    </style>
</head>
<body>
<div id="main">
    <form action="${ctx}/account/login" method="post" onsubmit="return check()">
        <h2>个人网上银行</h2>
        卡号：<input type="text" name="cardNo"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录网上银行">
    </form>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script>
    var errorMsg='${ErrorMsg}';
    if(errorMsg!=null && errorMsg!=undefined && errorMsg!='')
        alert(errorMsg);  
    
    function check() {
        var cardNo=$('input[name=cardNo]').val();
        var pwd=$('input[name=password]').val();
        if(cardNo==null||cardNo==''||pwd==null||pwd==''){
            alert("卡号,密码不能为空");
            return false;
        }
        if(cardNo.length!=16){
            alert("卡号必须为16位数字");
            return false;
        }
        if(pwd.length!=6){
            alert("密码必须为6位数字");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
