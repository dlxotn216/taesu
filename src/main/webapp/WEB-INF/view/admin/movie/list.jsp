<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${movie}" var="item">
	<div class="" style="min-height: 50px;">
		<a href="/movie/detail/${item.movieId}">${item.movieName} - ${item.regDate}</a>
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">링크복사</button>
	</div>
</c:forEach>

<a href="/movie/add">
	<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">add</button>
</a>

