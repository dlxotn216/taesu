<%--
  Created by IntelliJ IDEA.
  User: kim
  Date: 2016-12-01
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
    .account-manage-wrap{
        font-weight: bold !important;
    }
    .account-manage-wrap .form-group{
        margin-top: 20px;
    }
    .full-button{
        width: 100%;
    }

</style>

    <h1>Manage Accounts</h1>
    ${account.userId}의 회원정보<br><br><br>

<input type="hidden" id="userId" value="${account.userId}" />
<div class="account-manage-wrap">
    <div class="form-group">
        <div class="manage-label col-md-3"><span>사용자 이름</span><br></div>
        <div class="manage-content col-md-3"><span>${account.userName}</span></div>
    </div>
    <div class="clearfix"></div>
    <div class="form-group">
        <div class="manage-label col-md-3"><span>이메일</span><br></div>
        <div class="manage-content col-md-3"><span>${account.userEmail}</span></div>
    </div>
    <div class="clearfix"></div>
    <div class="form-group">
        <div class="manage-label col-md-3"><span>가입 요청일</span><br></div>
        <div class="manage-content col-md-3"><span>${account.requestDate}</span></div>
    </div>
    <div class="clearfix"></div>
    <div class="form-group">
        <div class="manage-label col-md-3"><span>계정 허가</span><br></div>
        <div class="col-md-3">
            <select id="permitSelect" class="form-control">
                <c:choose>
                    <c:when test="${account.permit == 'Y'}">
                        <option value="Y" selected>허가</option>
                        <option value="N">미허가</option>
                    </c:when>
                    <c:otherwise>
                        <option value="Y">허가</option>
                        <option value="N" selected>미허가</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="form-group">
        <div class="manage-label col-md-3"><span>허가 변경일</span><br></div>
        <div class="manage-content col-md-3"><span>${account.permitDate == NULL ? '.' : account.permitDate.toString().substring(0, 10)}</span></div>
    </div>
    <div class="clearfix"></div>
    <div class="form-group">
        <div class="manage-label col-md-3"><span>권한</span><br></div>
        <div class="manage-label col-md-3">
            <select id="authoritiesSelect"  class="form-control">
                <c:forEach var="authority" items="${authorities}">
                    <c:choose>
                        <c:when test="${account.authName == authority.authName}">
                            <option value="${authority.authName}" selected>${authority.authName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${authority.authName}">${authority.authName}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </select>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="form-group">
        <div class="col-md-2">
            <button class="btn btn-primary full-button" type="button" id="update">수정</button>
        </div>
        <div class="col-md-2">
            <button class="btn btn-warning full-button" type="button" id="delete">삭제</button>
        </div>
        <div class="col-md-2">
            <button class="btn btn-default full-button" type="button" id="cancel">뒤로</button>
        </div>
    </div>
</div>
<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#update").click(function(){
            var data = {
                "permit": $("#permitSelect").val(),
                "authName": $("#authoritiesSelect").val()
            }
            var userId= $("#userId").val();
            $.ajax({
                type:"PUT",
                url:"/master/account/user/"+userId,
                headers:{
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data),
                success: function(res){
                    console.log("DEBUG call update user authority and permit : "+res);
                }
            })
        });

        $("#cancel").click(function(){
            window.history.back();
        })
        $("#delete").click(function(){

            if(!confirm("삭제하시겠습니까")){
                return;
            }

            var userId= $("#userId").val();
            $.ajax({
                type:"DELETE",
                url:"http://localhost:8080/master/account/"+userId,
                headers:{
                  'Content-Type': 'application/json'
                },
                success:function(res){
                    console.log("DEBUG check res : "+res);
                    window.location.href="/master/account/list";
                }
            })
        })
    })

</script>