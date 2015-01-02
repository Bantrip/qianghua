<!DOCTYPE html>
<html>
  <head>
	<%@ page contentType="text/html;charset=UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<title></title>
    <c:set var="staticPath" value="${pageContext.request.contextPath}/static/front" />
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
   <meta name="staticPath" content="${staticPath}" />
    <link rel="stylesheet" href="${staticPath}/css/list.css">
  </head>
  <body>


  <div class="container">
      <div class="mod block-ope">
        <div class="location Fix">
          <dl class="list">
            <dt><span class="icon-location"></span>你的目的地</dt>
            <dd>曼谷</dd>
          </dl>
          <button type="button" class="btn btn-edit J_btn-edit">更改目的地</button>
        </div>
        <div class="filter">
          <dl class="item Fix">
            <dt>品类</dt>
            <dd class="on">全部</dd>
            <dd>收纳</dd>
            <dd>日化</dd>
            <dd>电子数码</dd>
            <dd>医护</dd>
            <dd>服饰</dd>
            <dd>户外</dd>
          </dl>
          <dl class="item Fix">
            <dt>适用人群</dt>
            <dd class="on">全部</dd>
            <dd>老人</dd>
            <dd>儿童</dd>
            <dd>男士</dd>
            <dd>女士</dd>
          </dl>
          <p class="other">
            <label class="seller">
              <input type="checkbox">自营商品
            </label>
          </p>
        </div>
      </div>
      <div class="mod block-list">
        <ul class="list Fix">
        <c:forEach items="${result}" var="item">
          <li><span class="icon-zan"></span>
          
          <a href="${ctx}/front/detail/${item.id}" class="top"><img src="${item.defaultPic}" class="img"><span class="price-bg"></span><span class="price">￥${item.price}</span></a>
            <div class="info"><a href="detail.html" class="name">${item.name}</a>
              <p class="location"><span class="icon-location"></span><c:forEach  items="${item.dests}" var="dest">
            	· ${dest.name}
            	</c:forEach></p>
              <p class="des">${item.recommand}</p>
            </div>
          </li>
          </c:forEach>
        </ul>
      </div>
    </div>

    <script>
    (function init(global){
    	if(global['facade']){
    		 facade({
    	          entry: 'bantrip/js/list.js',
    	          data: {
    	              pageType: 'app',
    	              token: ''
    	          }
    	      });
    	}else{
    		setTimeout(function(){init(global)},50)
    	}
     
      })(this)
    </script>

  </body>
</html>