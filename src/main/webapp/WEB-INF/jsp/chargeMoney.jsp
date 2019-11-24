<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>充值</h1>
<center>
	<form action="chargeMoney" method="post">
		充值金额：<input type="number" name="money">
		<br>
		<br>
		<input type="submit" value="确认充值">
	</form>
</center>
