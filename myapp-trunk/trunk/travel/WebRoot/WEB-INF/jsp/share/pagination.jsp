<%@ page language="java" pageEncoding="UTF-8"%>
<font color="#FFFFFF">
current page <font color="red" >${vo.pageView.currentPage }</font> | total record(s)${vo.pageView.totalRecordCount } | each page ${vo.pageView.maxResult }entries | ${vo.pageView.totalPage } pages | 
 <c:if test="${vo.pageView.currentPage>1}">
   <a href="javascript:topage('1')" class="a03"> first  </a>
 </c:if>
 <c:if test="${vo.pageView.currentPage==1}">
  <font color="grey"> first  </font>
 </c:if>
 <c:if test="${vo.pageView.currentPage>1}">
   <a href="javascript:topage('${vo.pageView.currentPage-1}')" class="a03"> prev  </a>
 </c:if>
 <c:if test="${vo.pageView.currentPage==1}">
  <font color="grey"> prev  </font>
 </c:if>
  <c:if test="${vo.pageView.currentPage<vo.pageView.totalPage}">
   <a href="javascript:topage('${vo.pageView.currentPage+1}')" class="a03"> next  </a>
 </c:if>
 <c:if test="${vo.pageView.currentPage==vo.pageView.totalPage}">
  <font color="grey"> next  </font>
 </c:if>
 <c:if test="${vo.pageView.pageIndex.startIndex>1}">
  ....
</c:if>
    	<c:forEach begin="${vo.pageView.pageIndex.startIndex}" end="${vo.pageView.pageIndex.endIndex}" var="wp">
    	<c:if test="${vo.pageView.currentPage==wp}"><b> ${wp } </b></c:if>
    	<c:if test="${vo.pageView.currentPage!=wp}">
    	     <a href="javascript:topage('${wp}')" class="a03"> <b><u> ${wp }</u></b>   </a>
    	</c:if> 
    	</c:forEach> 
    	
    	<c:if test="${vo.pageView.pageIndex.endIndex<vo.pageView.totalPage}">
  ....
       </c:if>
    	
  <c:if test="${vo.pageView.currentPage<vo.pageView.totalPage}">
   <a href="javascript:topage('${vo.pageView.totalPage}')" class="a03"> end  </a>
 </c:if>
 <c:if test="${vo.pageView.currentPage==vo.pageView.totalPage}">
  <font color="grey"> end  </font>
 </c:if>
 </font>
    	
    	
    	
    	