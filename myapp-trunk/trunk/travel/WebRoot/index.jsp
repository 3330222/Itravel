<%@ page contentType="text/html;charset=UTF-8" %>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <script>
 $(function(){
	 $.each("${list}", function (k, v) {
		 $("#img"+k+1).attr("src",v.themeImageUrl);
		 $("#title"+k+1).text(v.name);
	 })
 })
 </script>
 <div class ="row bot ">
      <div class ="row wow zoomIn" style ="text-align:center ;" >
         <section class="wwei-editor" style="color: #0000FF; font-family: 微软雅黑; font-size: 12px; white-space: normal; text-align: center; margin: 0px 1em; line-height: 1.6em;">
            <span style="font-family: 楷体,楷体_GB2312,SimKai;"></span>
            <section style="color: white; font-size: 1em; margin-top: -2.1em; white-space: nowrap;">
               <span style="font-size: 16px; font-family: 微软雅黑,Microsoft YaHei;">
                  颠覆
                  <section class="wwei-editor">
                     <h2 class="wweibrush" placeholder="请输入标题" style="white-space: normal; font-size: 16px; margin: 10px 0px; padding: 10px; max-width: 100%; border-top:solid 2px;border-left:0px; border-bottom:solid 2px; line-height: 25px; color: rgb(109, 151, 200);font-weight:bold; text-align: center;">
                        颠覆传统旅游，跟我来！
                     </h2>
                  </section>
                  传统旅游，跟我来吧
               </span>
               <span style="font-family: 黑体,SimHei; font-size: 16px;">！</span>
            </section>
         </section>
      </div>
      <div class="row">
         <div class="col-md-2"></div>
         <div class="col-md-4 wow zoomIn" style ="" >
            <img src="/resource/image/p1.jpg" alt="" style="height:190px;" id="img1"/>
            <div style ="padding-left:1em;">
               <p>
                  <span style="font-family: 微软雅黑,Microsoft YaHei; font-size: 20px;" id="title1">改了</span>
               </p>
               <p>        
                  <span style="font-family: 楷体,楷体_GB2312,SimKai;">老板说这有个副标题，谢谢老板！</span>
                  <button class="button button-primary button-circle button-tiny"><i class="fa fa-share"></i>
                  </button>
                  <br/>
               </p>
            </div>
         </div>
         <div class="col-md-4 wow zoomIn" >
            <img src="/resource/image/p2.jpg" alt="" style="height:190px;" id="img2"/>           
            <div style ="padding-left:1em;">
               <p>
                  <span style="font-family: 微软雅黑,Microsoft YaHei; font-size: 20px;" id="title2">老板说这里有一个标题</span>
               </p>
               <p>        
                  <span style="font-family: 楷体,楷体_GB2312,SimKai;">老板说这有个副标题，谢谢老板！</span>
                  <button class="button button-primary button-circle button-tiny"><i class="fa fa-share"></i>
                  </button>
                  <br/>
               </p>
            </div>
         </div>
         <div class="col-md-2"></div>
      </div>
      <div class="row">
         <div class="col-md-2"></div>
         <div class="col-md-4 wow zoomIn" style ="" >
            <img src="/resource/image/p3.jpg" alt="" style="height:190px;" id="img3"/>
            <div style ="padding-left:1em;">
               <p>
                  <span style="font-family: 微软雅黑,Microsoft YaHei; font-size: 20px;" id="title3">老板说这里有一个标题</span>
               </p>
               <p>        
                  <span style="font-family: 楷体,楷体_GB2312,SimKai;">老板说这有个副标题，谢谢老板！</span>
                  <button class="button button-primary button-circle button-tiny"><i class="fa fa-share"></i>
                  </button>
                  <br/>
               </p>
            </div>
         </div>
         <div class="col-md-4 wow zoomIn">
            <img src="/resource/image/p4.jpg" alt="" style="height:190px;" id="img4"/>
            <div style ="padding-left:1em;">
               <p>
                  <span style="font-family: 微软雅黑,Microsoft YaHei; font-size: 20px;" id="title4">老板说这里有一个标题</span>
               </p>
               <p>        
                  <span style="font-family: 楷体,楷体_GB2312,SimKai;">老板说这有个副标题，谢谢老板！</span>
                  <button class="button button-primary button-circle button-tiny"><i class="fa fa-share"></i>
                  </button>
                  <br/>
               </p>
            </div>
         </div>
         <div class="col-md-2"></div>
      </div>
      <div class="row">
         <div class="col-md-2"></div>
         <div class="col-md-4 wow zoomIn" style ="">
            <img src="/resource/image/p5.jpg" alt="" style="height:190px;" id="img5"/>
            <div style ="padding-left:1em;">
               <p>
                  <span style="font-family: 微软雅黑,Microsoft YaHei; font-size: 20px;" id="title5">老板说这里有一个标题</span>
               </p>
               <p>        
                  <span style="font-family: 楷体,楷体_GB2312,SimKai;">老板说这有个副标题，谢谢老板！</span>
                  <button class="button button-primary button-circle button-tiny"><i class="fa fa-share"></i>
                  </button>
                  <br/>
               </p>
            </div>
         </div>
         <div class="col-md-4 wow zoomIn">
            <img src="/resource/image/p6.jpg" alt="" style="height:190px;" id="img6"/>
            <div style ="padding-left:1em;">
               <p>
                  <span style="font-family: 微软雅黑,Microsoft YaHei; font-size: 20px;" id="title6">老板说这里有一个标题</span>
               </p>
               <p>        
                  <span style="font-family: 楷体,楷体_GB2312,SimKai;">老板说这有个副标题，谢谢老板！</span>
                  <button class="button button-primary button-circle button-tiny"><i class="fa fa-share"></i>
                  </button>
                  <br/>
               </p>
            </div>
         </div>
         <div class="col-md-2"></div>
      </div>
       </div>