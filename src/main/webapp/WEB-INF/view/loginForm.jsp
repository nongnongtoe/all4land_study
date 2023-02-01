<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="icon" href="data:,">
    <script src="/js/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>

    <style>
        .field-error {
            border-color: #dc3545;
            color: #dc3545;
        }
    </style>
</head>
<body>
<%@ include file="Logoutheader.jsp"%>
    <div class="container-sm">
        <h4 class="mb-3">회원 정보 입력</h4>

        <form action="/login" method="post">
            <div>
                <label for="email">이메일</label>
                <input type="text" name="email"  class="form-control">
            </div>

            <div>
                <label for="password">비밀번호</label>
                <input type="password" name="password" class="form-control">
            </div>

            <div class="d-grid gap-2">
            <button class="btn btn-primary" type="submit">로그인</button>
            <button type="button" class="btn btn-dark" onclick="location.href='/'">취소</button>
            </div>
        </form>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>