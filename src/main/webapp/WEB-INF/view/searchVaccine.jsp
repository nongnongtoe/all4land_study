<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <title>백신 검색</title>

<body>
<%@ include file="header.jsp"%>

<div class="container-sm">
<form class="form-signin">
  <div class="text-center mb-4">
    <img class="mb-4" src="/images/logo.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">접종 관리</h1>
    <p>아이의 생일을 통해 다음 접종 목록을 알 수 있습니다</p>
  </div>

  <div class="form-label-group w-25 text-center" style= "float:none; margin:0 auto" align="center">
    <input type="text" id="inputName" class="form-control" placeholder="아이의 이름" required autofocus>
    <label for=""></label>
  </div>

  <div class="form-label-group w-25 text-center" style= "float:none; margin:0 auto" align="center">
    <input type="date" id="inputBirth" class="form-control "  placeholder="아이의 생년월일" required autofocus>
  </div>
  <div class="text-center">
  <button class="btn btn-lg btn-primary btn-block  my-4  w-25 " style= "float:none; margin:0 auto" align="center" type="button">검색</button>
  </div>
</form>
</div>

<%@ include file="footer.jsp"%>
</body>
</html>