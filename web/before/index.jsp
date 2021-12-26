<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<%@taglib prefix="jstl-c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/before/index.js"></script>

</head>
<body>
<div id="container">
    <jsp:include page="/common/before/header.jsp"></jsp:include>
  <div id="menu">
      <ul class="menuUl">
          <li><a href="${pageContext.request.contextPath}/before/browseIndex?m=index">首页</a></li>
          <jstl-c:forEach items="${coffeeTypeList}" var="type">
              <li><a href="">${type.name}</a></li>
          </jstl-c:forEach>
          <li><a href="${pageContext.request.contextPath}/before/coffeeNews?m=list">咖啡咨询</a></li>
      </ul>
  </div>
  <div id="show">
        <img src="${pageContext.request.contextPath}/image/before/header-desktop.jpg" alt="">
    </div>
  <div id="content">
    <div id="goodsDiv">
        <h3>本周推荐</h3>
        <div id="goodsList">
            <jstl-c:forEach items="${coffeeList}" var="coffee">
                <div class="goods">
                    <img src="${pageContext.request.contextPath}/image/before/${coffee.picture}" alt="">
                    <span class="goodsName">${coffee.name}</span>
                    <span class="goodsPrice">${coffee.price}</span>
                </div>
            </jstl-c:forEach>
        </div>

    </div>
    <div id="news">
        <h3>新闻咨询</h3>
        <div class="newsContent">
            <jstl-c:forEach items="${coffeeNewsList}" var="news">
                <div class="title">
                    <a href="${pageContext.request.contextPath}/before/coffeeNews?m=detail&id=${news.id}">${news.title}</a>
                </div>
                <div class="time">
                        ${news.addtime}
                </div>
            </jstl-c:forEach>
        </div>
    </div>
    <jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
</body>
</html>