<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ocpsoft" uri="http://ocpsoft.org/prettytime/tags" %>

<input type="hidden" id="movie-domain" value="${DOMAIN}">
<c:forEach items="${movie}" var="item">
	<div class="" style="min-height: 50px; margin-bottom:20px;">
		<a href="/admin/movie/${item.movieId}">${item.movieName} - <ocpsoft:prettytime date="${item.regDate}" locale="ko_KR"/></a>

		<!--
		<button class="btn btn-sm btn-success" data-clipboard-text="${DOMAIN}/${item.movieId}">
		<span class="glyphicon glyphicon-link"></span>
		</button>
		-->

		<div class="input-group">
			<span class="glyphicon glyphicon-link input-group-addon"></span>
			<input type="text" readonly="readonly" value="${DOMAIN}/${item.movieId}" class="form-control"/>
		</div>

	</div>
</c:forEach>

<a href="/admin/movie/add">
	<button class="btn btn-primary">등록</button>
</a>

