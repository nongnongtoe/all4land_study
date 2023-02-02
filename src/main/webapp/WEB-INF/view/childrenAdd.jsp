<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="/static/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="./css/bootstrap.css">

    <title>내 아이 글쓰기 페이지</title>
</head>
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<form action="/children/add" method="post">
    <div class="text-center">
        <img src="/images/logo.jpg" class="rounded" alt="...">
    </div>
    <div class="form-group" style="margin-left: 17%; margin-right: 17%">
        <input class="form-control" type="text" name="name" placeholder="아이의 이름을 입력하세요.">
    </div>
    <br>
    <button type="submit" class="btn btn-primary btn-sm" style="margin-left: 70%">입력하기</button>
    <button type="reset" class="btn btn-secondary btn-sm" onclick="location.href='/children'">취소</button>
</form>
<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>
</html>