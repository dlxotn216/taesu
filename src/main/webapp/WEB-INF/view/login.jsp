<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#createAccountBtn").click(function () {
            window.location.href='/account/create';
        });
    })

</script>
<h1>
    로그인
</h1>
<c:if test="${param.error == true}">
    <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
</c:if>
<div class="col-md-8">
    <div class="form-group">
        <form action="/loginprocess" method="post">
            <div class="mdl-textfield mdl-js-textfield is-upgraded" data-upgraded=",MaterialTextfield">
                <input type="text" name="id" placeholder="계정" class="form-control" required="required"/>
            </div>
            <div class="mdl-textfield mdl-js-textfield is-upgraded" data-upgraded=",MaterialTextfield">
                <input type="password" name="passwd" placeholder="암호" class="form-control" required="required"/>
            </div>
            <br><br>
            <div class="mdl-textfield mdl-js-textfield is-upgraded" data-upgraded=",MaterialTextfield">
                <input type="submit" class="form-control btn btn-primary" value="로그인"/>
            </div>
            <br>
            <div class="mdl-textfield mdl-js-textfield is-upgraded" data-upgraded=",MaterialTextfield">
                <p class="form-control-static" style="text-align: center;">아직 계정이 없으십니까?</p>
                <input id="createAccountBtn" type="button" class="form-control btn btn-default" value="회원가입"/>
            </div>
    </form>
    </div>
</div>

