<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.form-group {
	display: block;
}
.form-group .form-label {
	display: inline-block;
	width: 80px;
}
</style>
<form action="/movie/add" method="POST">
	<div class="form-group">
		<span class="form-label">name</span>
		<div class="mdl-textfield mdl-js-textfield">
			<input name="movieName" class="mdl-textfield__input" type="text" id="movieName">
			<label class="mdl-textfield__label" for="movieName">Text...</label>
		</div>
	</div>
	<div class="form-group">
		<span class="form-label">link</span>
		<div class="mdl-textfield mdl-js-textfield">
			<input name="movieLink" class="mdl-textfield__input" type="text" id="link1">
			<label class="mdl-textfield__label" for="link1">Text...</label>
		</div>
	</div>
	<div class="form-group">
		<span class="form-label">link</span>
		<div class="mdl-textfield mdl-js-textfield">
			<input name="movieLink" class="mdl-textfield__input" type="text" id="link2">
			<label class="mdl-textfield__label" for="link2">Text...</label>
		</div>
	</div>
	<div class="form-group">
		<span class="form-label">link</span>
		<div class="mdl-textfield mdl-js-textfield">
			<input name="movieLink" class="mdl-textfield__input" type="text" id="link3">
			<label class="mdl-textfield__label" for="link3">Text...</label>
		</div>
	</div>
	<div class="form-group">
		<span class="form-label">link</span>
		<div class="mdl-textfield mdl-js-textfield">
			<input name="movieLink" class="mdl-textfield__input" type="text" id="link4">
			<label class="mdl-textfield__label" for="link4">Text...</label>
		</div>
	</div>
	<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">등록</button>
</form>