<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl-c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/before/index.js"></script>
</head>
<body>
<div id="container">
    <jsp:include page="/common/before/header.jsp"></jsp:include>
  <div id="menu">
      <ul class="menuUl">
          <li><a href="">首页</a></li>
          <jstl-c:forEach items="${coffeeTypeList}" var="type">
              <li><a href="">${type.name}</a></li>
          </jstl-c:forEach>>
          <li><a href="">咖啡咨询</a></li>
      </ul>
  </div>
  <div id="show">
      <img src="${pageContext.request.contextPath}/" alt="">
  </div>
  <div id="content">
    <div id="goodsDiv">
        <h3>本周推荐</h3>
        <div id="goodsList">
            <div class="goods">
                <img src="${pageContext.request.contextPath}/" alt="">
                <span class="goodsName">描述</span>
                <span class="goodsPrice">单价</span>
            </div>
            <div class="goods">
                <img src="${pageContext.request.contextPath}/" alt="">
                <span class="goodsName">描述</span>
                <span class="goodsPrice">单价</span>
            </div>
            <div class="goods">
                <img src="${pageContext.request.contextPath}/" alt="">
                <span class="goodsName">描述</span>
                <span class="goodsPrice">单价</span>
            </div>
            <div class="goods">
                <img src="${pageContext.request.contextPath}/" alt="">
                <span class="goodsName">描述</span>
                <span class="goodsPrice">单价</span>
            </div>
            <div class="goods">
                <img src="${pageContext.request.contextPath}/" alt="">
                <span class="goodsName">描述</span>
                <span class="goodsPrice">单价</span>
            </div>
        </div>

    </div>
    <div id="news">
        <h3>新闻咨询</h3>
        <div class="newsContent">
        <div class="title">
            <a href="">标题</a>
        </div>
            <div class="time">
            时间
            </div>
        </div>
        <div class="newsContent">
            <div class="title">
                <a href="">标题</a>
            </div>
            <div class="time">
                时间
            </div>
        </div>
        <div class="newsContent">
            <div class="title">
                <a href="">标题</a>
            </div>
            <div class="time">
                时间
            </div>
        </div>

    </div>
  </div>
    <jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
</body>
</html>