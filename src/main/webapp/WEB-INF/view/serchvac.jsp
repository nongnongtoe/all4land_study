<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <title>백신 검색</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <link href="floating-labels.css" rel="stylesheet


<body>
<%@ include file="header.jsp"%>


<form class="form-signin">
  <div class="text-center mb-4">
    <img class="mb-4" src="images/logo.jpg" alt="" width="72" height="72">
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


<%@ include file="footer.jsp"%>
</body>
</html>