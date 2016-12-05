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

<div class="col-md-8">

	<form id="movieEditForm" action="/admin/movie/add" method="POST" data-movie-id="${MOVIE.movieId}">
		<div class="form-group">
			<label>${MOVIE.regUserId} 님이 <ocpsoft:prettytime date="${MOVIE.regDate}" locale="ko_KR"/> 입력한 내용입니다.</label>
		</div>

		<div class="form-group">
			<label>name</label>
			<input type="text" class="form-control" name="movieName" value="${MOVIE.movieName}">
		</div>

		<div class="form-group">
			<label>account</label>
			<select name="fbAccountId" value="${MOVIE.fbAccountId}">
				<c:forEach items="${FB}" var="item">
					<option value="${item.fbAccountId}">${item.fbUserName} - ${item.fbUserId}</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label>Link</label>
			<ul class="list-group">
				<c:forEach items="${MOVIE_LINK}" var="item">
					<li class="list-group-item">
						<input type="text" class="form-control" name="links" value="${item.movieUrl}">
					</li>
				</c:forEach>
			</ul>
		</div>
	</form>
	<a href="/admin/movie/list">
		<button class="btn btn-success">목록으로</button>
	</a>
	<button id="btn-movie-update" class="btn btn-primary">수정</button>
	<button id="btn-movie-delete" class="btn btn-primary">삭제</button>
</div>

