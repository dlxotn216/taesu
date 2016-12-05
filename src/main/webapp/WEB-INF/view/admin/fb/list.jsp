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
	<c:forEach items="${FB}" var="item">
		<div class="" style="min-height: 50px;">
			<a href="/admin/fb/${item.fbAccountId}">${item.fbUserId} - <ocpsoft:prettytime date="${item.regDate}" locale="ko_KR"/></a>
			<button class="btn btn-sm btn-success">
				<span class="glyphicon glyphicon-link"></span>
			</button>
		</div>
	</c:forEach>
	<a href="/admin/fb/add">
		<button class="btn btn-primary">등록</button>
	</a>
</div>