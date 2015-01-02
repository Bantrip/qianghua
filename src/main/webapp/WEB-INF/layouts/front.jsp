<!DOCTYPE html>
<html>
  <head>
	<%@ page contentType="text/html;charset=UTF-8"%>
    <%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<title><sitemesh:title/> 旅途商品,上伴游</title>
    <c:set var="staticPath" value="${pageContext.request.contextPath}/static/front" />
	<meta name="staticPath" content="${staticPath}" />
	<meta name="renderer" content="webkit">
	<sitemesh:head/>
  </head>
  <body>
    <div class="pg-hd">
      <div class="container">
        <div class="info">
        <!-- 
          <div class="user"><img src="http://tp4.sinaimg.cn/1969110243/180/5695186658/0" class="portrait">
          	<span class="name">5k2014</span><span class="icon-arrow"></span>
          </div>
          <a href="" class="cart"><span class="icon-cart"></span><span class="num">99</span><span class="name">购物车</span></a>
        -->
       	</div> <a href="" class="logo"><img src="${staticPath}/images/logo.png"></a>
      </div>
    </div>
    <sitemesh:body/>      
    <script src="${staticPath}/neurons/neuron.js"></script>
    <script src="${staticPath}/neurons/config.js"></script>
    <script>
      neuron.config({
          path: '${staticPath}/neurons'
      })
    </script>
    

  </body>
</html>


