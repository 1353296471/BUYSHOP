<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<ul id="etalage">
	<li>
		<a href="optionallink.html">
			<img class="etalage_thumb_image" src="images/${requestScope.proImagUrl }" class="img-responsive" />
			<img class="etalage_source_image" src="images/${requestScope.proImagUrl }" class="img-responsive" title="" />
		</a>
	</li>
</ul>
<div class="clearfix"></div>