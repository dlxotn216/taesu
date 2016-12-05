<%--
  Created by IntelliJ IDEA.
  User: kim
  Date: 2016-12-01
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-8">

	<form action="/admin/fb/add" method="POST">

		<div class="form-group">
			<label>id</label>
			<input type="text" class="form-control" name="fbUserId">
		</div>

		<div class="form-group">
			<label>name</label>
			<input type="text" class="form-control" name="fbUserName">
		</div>

		<button class="btn btn-primary">register</button>
	</form>
</div>