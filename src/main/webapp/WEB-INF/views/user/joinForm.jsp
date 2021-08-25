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

        <div class="form-group">
            <label for="name">이름 </label>
            <input type="text" class="form-control" placeholder="이름을 입력해주세요." id="name">
        </div>

        <div class="form-group">
            <label for="birth">생년월일 </label>
            <input type="date" class="form-control" id="birth">
        </div>

        <div class="form-group">
            <label for="tel">전화번호 </label>
            <input type="tel" class="form-control" id="tel">
        </div>


        <div class="form-group">
            <label for="email">이메일</label>
            <input required type="email" class="form-control" placeholder="Enter email" id="email">
        </div>

        <button type="submit" class="btn btn-primary">회원가입완료</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>