<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<option value="1"></option>

<c:forEach items='${requestScope.sizeList }' var="_size">
<c:choose>
<c:when test="${_size==1 }">
   <option value="2">S</option>
</c:when>
<c:when test="${_size==2 }">
   <option value="2">M</option>
   </c:when>
 <c:otherwise> 
   <option value="3">L</option>
 </c:otherwise> 
</c:choose>
</c:forEach>


