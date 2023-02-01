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
    <div class="container-sm">
        <h4 class="mb-3">회원 정보 입력</h4>

        <form name="userForm" action="/user/add" method='post'>
            <div>
                <label for="email">이메일</label>
                <input type="text" name="email"  class="form-control">
            </div>

            <div>
                <label for="password">비밀번호</label>
                <input type="password" name="password" class="form-control">
            </div>


            <div>
                <label for="phone">핸드폰</label>
                <input type="text" name="phone" class="form-control">
            </div>


            <hr class="my-4">

            <div>
                <input type="checkbox" name="adminCheck" class="form-check-input">
                <input type="hidden" name="_adminCheck" value="on">
                <label for="adminCheck">관리자 권한 체크</label>
            </div>

            <div class="d-grid gap-2">
                <button class="btn btn-primary" type="submit">회원 가입</button>
                <button type="button" class="btn btn-dark" onclick="location.href='/'">취소</button>
            </div>
        </form>
    </div>
</body>


<script>
</script>
</html>