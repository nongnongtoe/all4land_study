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
    <link rel="stylesheet" href="/bootstrap.css">

    <title>내 아이 페이지</title>
</head>
<body>
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<c:forEach items="${child}" var="child">
    <div style="margin-left: 40%; margin-right: 40%">
        <!--아이 삭제 버튼-->
        <button type="button" class="close" aria-label="Close"
                onclick="location.href='childrenHistory/delete/${child.id}'">
            <span aria-hidden="true">&times;</span>
        </button>
        <a href="/childrenHistory/${child.id}">
            <img src="images/pig${child.id}.jpg" alt="..." width="350" height="350" class="img-thumbnail">
            <p align="center" class="font-weight-bold">${child.name}</p>
        </a>
    </div>
</c:forEach>
<button type="button" class="btn btn-primary btn-sm" onclick="location.href='/childrenHs/add'" style="margin-left: 80%">
    글쓰기
</button>

<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>
</html>