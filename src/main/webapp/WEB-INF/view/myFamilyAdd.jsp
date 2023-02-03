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
    <script src="/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">

    <title>가족력 글쓰기 페이지</title>
</head>
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<form action="/myFamily/add" method="post">
    <div class="form-group" style="margin-left: 17%; margin-right: 17%">
        <input class="form-control" type="text" name="name" placeholder="제목을 입력하세요.">
    </div>
    <br>
    <div class="form-group" style="margin-right: 17%; margin-left: 17%;">
        <textarea class="form-control" name="memo" placeholder="내용을 입력하세요." id="exampleFormControlTextarea1" rows="20"></textarea>
    </div>
    <button type="submit" class="btn btn-primary btn-sm" style="margin-left: 77%">글쓰기</button>
    <button type="reset" class="btn btn-secondary btn-sm" onclick="location.href='/myFamily'">취소</button>
</form>
<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>
</html>