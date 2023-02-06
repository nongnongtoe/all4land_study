<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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

    <title>공지사항</title>
</head>
<body>
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<div style="margin-left: 17%; margin-right: 17%">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
        </tr>
        </thead>
        <tbody>
        <tr>
                <td>${post.title}</td>
                <td>${user.role}</td>
                <td>${post.date}</td>
        </tr>
        </tbody>

    </table>
    <table class="table">
            <thead>
            <tr>
                <th scope="col">내용</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                    <td>${post.content}</td>
            </tr>
            </tbody>

        </table>
</div>

<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>
</html>