<%--
  Created by IntelliJ IDEA.
  User: kim
  Date: 2016-12-01
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ocpsoft" uri="http://ocpsoft.org/prettytime/tags" %>

<div class="col-md-8">
	<form id="fbForm" action="/admin/fb/add" method="POST" data-fb-id="${FB.fbAccountId}">
		<div class="form-group">
			<label>${FB.regUserId} 님이 <ocpsoft:prettytime date="${FB.regDate}" locale="ko_KR"/> 입력한 내용입니다.</label>
		</div>

		<div class="form-group">
			<label>id</label>
			<input type="text" class="form-control" name="fbUserId" value="${FB.fbUserId}">
		</div>

		<div class="form-group">
			<label>name</label>
			<input type="text" class="form-control" name="fbUserName" value="${FB.fbUserName}">
		</div>
	</form>
	<a href="/admin/fb/list">
		<button type="button" class="btn btn-success">목록으로</button>
	</a>
	<button id="btn-fb-update" type="button" class="btn btn-primary">수정</button>
	<button id="btn-fb-delete" type="button" class="btn btn-danger">삭제</button>
</div>