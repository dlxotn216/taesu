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


<div class="col-md-12">
	<div>
		<h3>text</h3>
	</div>
	<div>${MOVIE.movieName}</div>
	<div>
		<c:forEach items="${MOVIE_LINK}" var="item">
			<li class="list-group-item">
				<input type="text" class="form-control" name="links" value="${item.movieUrl}">
			</li>
		</c:forEach>
	</div>
	<div>
		<a href="https://www.facebook.com/profile.php?id=${FB.fbUserId}">${FB.fbUserName}</a>
	</div>
</div>