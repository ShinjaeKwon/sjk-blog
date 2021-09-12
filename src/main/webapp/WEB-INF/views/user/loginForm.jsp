
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form action="#" method="post">
        <div class="form-group">
            <label for="userId">아이디 </label>
            <input type="text" name="userId" class="form-control" placeholder="아이디를 입력해주세요." id="userId">
        </div>

        <div class="form-group">
            <label for="password">패스워드 </label>
            <input type="password" name="password" class="form-control" placeholder="패스워드를 입력해주세요." id="password">
        </div>

        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" name="remember" type="checkbox"> Remember me
            </label>
        </div>
        <button id="btn-login" class="btn btn-primary">로그인</button>
    </form>

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>