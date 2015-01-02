<!DOCTYPE html>
<html>
  <head>
	<%@ page contentType="text/html;charset=UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<title>${result.name}</title>
    <c:set var="staticPath" value="${pageContext.request.contextPath}/static/front" />
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
   <meta name="staticPath" content="${staticPath}" />
    <link rel="stylesheet" href="${staticPath}/css/index.css">
  </head>
  <body>


  <div class="tc-banner"><span class="arrow prev"></span><span class="arrow next"></span>
  <ul class="con">
  <c:forEach items="${lunboAd}" var="ad">
  	<li><a href="${ad.url}" target="_blank" style="background: url(${ad.pic}) center center no-repeat;"></a></li>
  </c:forEach>
     
      </ul>
    </div>
    
    <div class="container section-search Fix">
      <div class="result">
        <h3 class="tit"><span class="icon-dot"></span>搜索目的地</h3>
        <div class="block">
          <div class="search"><span class="icon-search"></span>
            <input type="text" placeholder="搜索国家、城市、景点" class="input J_search-city" data-url="${ctx}/search/dest.json">
            <!-- <div class="nav"><a href="javascript:;">北美</a><span>></span><a href="javascript:;">北美</a><span>></span><span>美国</span></div> -->
          </div>
          <div class="list J_city-list">
            <ul class="con">
            </ul>
            <div class="loading"></div>
          </div>
        </div>
      </div>
      <div class="select">
        <h3 class="tit"><span class="icon-dot"></span>已选择目的地</h3>
        <ul class="list J_city-select-list">
        	<c:forEach items="${dests}" var="dest">
        		<li class="city" data-cityid="${dest.id}"><span class="icon-del">X</span> ${dest.name } </li>
        	</c:forEach>
        </ul><a href="${ctx}/search/toList" data-url="${ctx}/search/toList" id="J_to-list" class="btn-view">查看商品</a>
      </div>
    </div>

    <script>
    (function init(global){
    	if(global['facade']){
    		 facade({
    	          entry: 'bantrip/js/index.js',
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