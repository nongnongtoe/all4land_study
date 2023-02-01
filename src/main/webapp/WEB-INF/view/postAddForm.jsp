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
<%@ include file="header.jsp"%>
    <div class="container-sm">
        <h4 class="mb-3">공지사항 입력</h4>

        <form action="/post/add" method="post">
            <div>
                <label for="title">제목</label>
                <input type="text" name="title"  class="form-control">
            </div>
            <div>
                <label for="date">작성일</label>
                <input type="date" name="date" id="now_date" class="form-control">
            </div>
            <div>
                <label for="content">내용</label>
                <textarea  name="content" class="form-control" rows="20"></textarea>
            </div>

            <div class="d-grid gap-2">
            <button class="btn btn-primary" type="submit">작성</button>
            <button type="button" class="btn btn-dark" onclick="location.href='/'">취소</button>
            </div>
        </form>
    </div>

    <%@ include file="footer.jsp" %>

    <script>
    document.getElementById('now_date').valueAsDate = new Date();
    </script>


</body>
</html>