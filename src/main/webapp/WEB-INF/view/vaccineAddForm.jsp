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
        <h4 class="mb-3">백신 입력</h4>

        <form action="/vaccine/add" method="post">
            <div>
                <label for="startVaccine">백신 시작일</label>
                <input type="number" name="startVaccine"  class="form-control">
                <label for="endVaccine">백신 종료일</label>
                <input type="number" name="endVaccine"  class="form-control">
            </div>
            <div>
                <label for="title">내용</label>
                <input type="text"  name="title" class="form-control" rows="20">
            </div>

            <div class="d-grid gap-2">
            <button class="btn btn-primary" type="submit">작성</button>
            <button type="button" class="btn btn-dark" onclick="location.href='/'">취소</button>
            </div>
        </form>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>