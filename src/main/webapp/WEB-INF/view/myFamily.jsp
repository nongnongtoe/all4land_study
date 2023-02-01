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

  <title>우리 아이 백신 홈페이지</title>
</head>
<body>
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<table class="table">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">First</th>
    <th scope="col">Last</th>
    <th scope="col">Handle</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <th scope="row">1</th>
    <td>Mark</td>
    <td>Otto</td>
    <td>@mdo</td>
  </tr>
  <tr>
    <th scope="row">2</th>
    <td>Jacob</td>
    <td>Thornton</td>
    <td>@fat</td>
  </tr>
  <tr>
    <th scope="row">3</th>
    <td>Larry</td>
    <td>the Bird</td>
    <td>@twitter</td>
  </tr>
  </tbody>
</table>
<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>
</html>