<%--
  Created by IntelliJ IDEA.
  User: sec
  Date: 2021-08-25
  Time: 오후 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form action="/action_page.php">
        <div class="form-group">
            <label for="userId">아이디 </label>
            <input type="text" class="form-control" placeholder="아이디를 입력해주세요." id="userId">
        </div>

        <div class="form-group">
            <label for="pwd">패스워드 </label>
            <input type="password" class="form-control" placeholder="패스워드를 입력해주세요." id="pwd">
        </div>

        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-primary">회원가입완료</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>