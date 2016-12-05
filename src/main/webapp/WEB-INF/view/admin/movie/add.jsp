<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-8">

	<form action="/admin/movie/add" method="POST">

		<div class="form-group">
			<label>name</label>
			<input type="text" class="form-control" name="movieName">
		</div>

		<div class="form-group">
			<label>account</label>
			<select name="fbAccountId">
				<c:forEach items="${FB}" var="item">
					<option value="${item.fbAccountId}">${item.fbUserName} - ${item.fbUserId}</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label>Link</label>
			<ul class="list-group">
				<li class="list-group-item">
					<input type="text" class="form-control" name="links">
				</li>
				<li class="list-group-item">
					<input type="text" class="form-control" name="links">
				</li>
				<li class="list-group-item">
					<input type="text" class="form-control" name="links">
				</li>
				<li class="list-group-item">
					<input type="text" class="form-control" name="links">
				</li>
			</ul>
		</div>
		<button class="btn btn-primary">register</button>
	</form>
</div>