
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="username">아이디 </label>
            <input type="text" class="form-control" placeholder="아이디를 입력해주세요." id="username">
        </div>

        <div class="form-group">
            <label for="password">패스워드 </label>
            <input type="password" class="form-control" placeholder="패스워드를 입력해주세요." id="password">
        </div>

        <div class="form-group">
            <label for="nickname">닉네임 </label>
            <input type="text" class="form-control" placeholder="닉네임을 입력해주세요." id="nickname">
        </div>

        <div class="form-group">
            <label for="email">이메일</label>
            <input required type="email" class="form-control" placeholder="Enter email" id="email">
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">회원가입완료</button>
    <br><br>

</div>
<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>