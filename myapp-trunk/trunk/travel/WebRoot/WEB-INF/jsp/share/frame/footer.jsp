<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/share/tagLibs.jsp" %>
 
<div class="footer_my">
         <div class ="row">
            <div class="col-md-1"></div>
            <div class="col-md-7  ">
               
                      <div class="bdsharebuttonbox">
			        <a href="#" class="bds_more" data-cmd="more"></a>
			        <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
			        <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
			        <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
			        <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
			        <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
                    <script>
                       
                    </script>
		            </div>
		         
               <p >Copyright © 2015 www.qimaero.com</p>
            </div>
            <div class="col-md-3"></div>
         </div>
      </div>
      <script>
      $(function(){
    	  init();   	  
      });
      function init(){
    	  window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"16"},
                  "share":{},
                  "image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},
                  "selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}
                  };
		with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
      }
      </script>