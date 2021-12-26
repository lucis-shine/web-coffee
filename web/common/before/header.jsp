<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div id="top"></div>
<div id="search">
    <div class="navSearchDiv">
        <input value="请输入关键词搜索" id="key" name="key">
        <img alt="" src="${pageContext.request.contextPath}/image/before/searchLogo.png">
    </div>
    <c:if test="${webUserLogin eq null }">
        <ul class="userLoginDiv">
            <li><a href="${pageContext.request.contextPath }/before/user/login.jsp">登录</a></li>
            <li>/</li>
            <li><a href="${pageContext.request.contextPath }/before/user/register.jsp">注册</a></li>
        </ul>
    </c:if>
    <c:if test="${webUserLogin ne null }">
        <ul class="userLoginDiv">
            <li><a href="#">${webUserLogin.name}</a></li>
            <li class="dropdown">
                <div class="dropdown-toggle" id="userOperatorDiv" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <a class="glyphicon glyphicon-user">会员中心</a>
                    <b class="caret"></b>
                </div>
                <ul class="dropdown-menu" aria-labelledby="dLabel" id="dropdownMenuUl">
                    <li><a href="${pageContext.request.contextPath }/filter/before/orders?m=list">我的订单</a> </li>
                    <li><a href="${pageContext.request.contextPath }/filter/before/cart?m=list">我的购物车</a> </li>
                    <li><a href="${pageContext.request.contextPath }/before/address/add.jsp">添加地址</a> </li>
                    <li><a href="${pageContext.request.contextPath }/filter/before/address?m=list">我的地址</a> </li>
                    <li><a href="${pageContext.request.contextPath }/filter/before/collects?m=list">我的收藏</a> </li>
                    <li><a href="${pageContext.request.contextPath }//before/user?m=exit">退出</a> </li>
                </ul>
            </li>
        </ul>
    </c:if>


</div>
</body>
</html>