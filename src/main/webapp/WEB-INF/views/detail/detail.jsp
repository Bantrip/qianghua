<!DOCTYPE html>
<html>
  <head>
	<%@ page contentType="text/html;charset=UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<title>${result.name}</title>
    <c:set var="staticPath" value="${pageContext.request.contextPath}/static/front" />
	<meta name="staticPath" content="${staticPath}" />
    <link rel="stylesheet" href="${staticPath}/css/detail.css">
  </head>
  <body>


    <div class="container mod info-main Fix">
      <div class="lf">
        <h4 class="tit">${result.name} </h4>
        <div class="img-box">
          <div class="big"><span class="arrow prev"></span><span class="arrow next"></span>
            <span class="cont">
              <img class="J_main-img" src="${result.defaultPic }">
            </span>
          </div>
          <div class="small">
            <ul class="Fix J_trigger-img">
            	<c:forEach items="${result.images }" var="imgVar" varStatus="stat">
              		<li <c:if test="${ stat.index==0}"> class="on"</c:if> data-url="${imgVar}"><img src="${imgVar}"></li>
              	</c:forEach>
            </ul>
          </div>
        </div>
      </div>
      <div class="rt">
        <div>
          <p class="price">￥${result.price}</p>
          <!-- 
          <p class="num">
            <label>数量</label><span class="icon reduce J_amount-reduce disable">-</span>
            <input type="text" value="1" class="J_amount-input"><span class="icon add J_amount-add">+</span>
          </p>
          <p class="ope">
            <button type="button" class="btn"><span class="icon-cart"></span>加入购物车</button>
          </p>
          -->
          <p class="ope">
            <a target="_blank" href="${result.url}" class="btn">去购买</a>
          </p>
        </div>
        <dl class="reason">
          <dt>推荐理由</dt>
          <dd>
            <p>${result.recommand}</p>
          </dd>
        </dl>
        
        <div class="interact Fix">
        <!--   <a href="javascript:;" class="like J_btn-like liked"><span class="icon icon-like"></span>喜欢 28888</a>
          <a href=""><span class="icon icon-edit"></span>写评论</a>
          <a href=""><span class="icon icon-share"></span>分享<span class="icon icon-arrow"></span></a>
         -->
        </div>
      </div>
    </div>


<div class="container mod info-detail Fix">
      <div class="lf">
        <div class="block detail">
          <h4 class="tit"><span class="icon icon-bag"></span>商品详情</h4>
          <div class="con">
           <div class="img">
            <c:forEach items="${result.descs}" var="desc">
							 <c:if test="${desc.type==0}">
							 	<p>${desc.content}</p>                   
                             </c:if>
                             <c:if test="${desc.type==1}">
                             	<img src="${desc.content}">
                             </c:if>
                             
               </c:forEach>
          </div>
          </div>
        </div>
       
      </div>
      <div class="rt">
        <div class="block location">
          <h4 class="tit"><span class="icon icon-location"></span>适用目的地</h4>
          <div class="con">
            <ul class="list">
            <c:forEach  items="${result.dests}" var="dest">
            	<li>· ${dest.name}</li>
            </c:forEach>
            </ul>
            <p class="back"><a href="">返回目的地商品列表页>></a></p>
          </div>
        </div>
      </div>
    </div>




      
    <script>
    (function(global){
    	(function run(){
    		if(global['facade']){
    			facade({
    		          entry: 'bantrip/js/detail.js',
    		          data: {
    		              pageType: 'app',
    		              token: ''
    		          }
    		      })
    		}else{
    			setTimeout(run,50);
    		}
    	})();
    })(this);
      
    </script>
    

  </body>
</html>