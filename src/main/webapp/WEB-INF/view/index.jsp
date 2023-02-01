<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/bootstrap.css">
  <title>메인화면</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  <style>
    #notice-tab-wrap {
      margin-left: 65%;
      margin-right: 15%;
    }

    #notice-tab-wrap {
      width: 35.91269841269841%; /*362px*/
      height: 332px;
      border: 1px solid #aa7d80;
      border-radius: 7px;
      background-color: #fff;
      position: relative;
      margin-bottom: 40px;
      float: right;
      padding: 22px 13px;
    }

    #notice-tab-wrap li {
      height: 37px;
      line-height: 37px;
      position: relative;
      padding-left: 24px;
      padding-right: 50px;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    #notice-tab-wrap li span {
      position: absolute;
      top: 0;
      right: 0;
      font-size: 12px;
    }

    #notice-tab-wrap .no-write {
      text-align: center;
    }

    #notice-tab-wrap .icon-more {
      position: absolute;
      top: 24px;
      right: 16px;
      color: #b40a13;
      font-size: 12px;
    }

    #notice-tab-wrap > div {
      display: none;
    }

    #notice-tab-wrap > div.tab-container-1 {
      display: block;
    }
  </style>
  <title>우리 아이 백신 홈페이지</title>
</head>
<body>
<!--Before Login Header Area-->
<div class="container">
  <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
    <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
        <use xlink:href="#bootstrap"/>
      </svg>
    </a>

    <ul class="nav nav-tabs">
      <li class="nav-item"><a href="#" class="nav-link px-2 link-secondary">Home</a></li>&nbsp;&nbsp;&nbsp;
      </li>
      </li>
      <li class="nav-item"><a href="#" class="nav-link px-2 link-dark">Community</a></li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
           aria-expanded="false">관련 사이트</a>&nbsp;&nbsp;&nbsp;
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">need to modify</a>&nbsp;&nbsp;&nbsp;
          <a class="dropdown-item" href="#">need to modify</a>
        </div>
      </li>
    </ul>

    <div class="col-md-3 text-end">
      <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/login'">Login</button>
      <button type="button" class="btn btn-primary" onclick="location.href='/user/add'">Sign-up</button>
    </div>
  </header>
</div>
<!--Container Area-->
<!-- 콘테이너.슬라이드 영역 -->
<div id="carouselExampleIndicators" class="carousel slide" style="width: 500px; height: 300px; position: relative;  margin-left:300px;"
     data-ride="carousel">
  <ol class="carousel-indicators" align:
  "center" style="position: absolute; bottom: -50px;">
  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/dog1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/dog2.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/dog3.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" style="position: absolute; top: 0px; left : 0px; "
          data-target="#carouselExampleIndicators" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" style="position: absolute; top: 0px; right:0px; "
          data-target="#carouselExampleIndicators" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </button>
</div>
<section id="notice-tab-wrap">
  <!-- 콘테이너.게시판 영역 -->
  <h3 class="sec-tit-1">NOTICE &amp; NEWS</h3>
  <button type="button" class="btn btn-outline-primary">공지사항</button>
  <button type="button" class="btn btn-outline-primary">새소식</button>
  <div class="tab-container-1" style="margin-top: 10px">
    <ul class="list-group">
      <li class="list-group-item" style="padding-bottom: 10px; padding-left: 10px"><a href="#">공지사항 관련된 내용입니다.</a><span>2017.08.07 &nbsp;</span>
      </li>
      <li class="list-group-item" style="padding-bottom: 50px; padding-left: 10px"><a href="#">공지사항 관련된 내용입니다.</a><span>2017.08.07 &nbsp;</span>
      </li>
    </ul>
    <p class="icon-more"><a href="#">more</a></p>
  </div>
  <br>
  <div class="tab-container-2">
    <p class="no-write">등록된 내용이 없습니다.</p>
  </div>
</section>
<!--Footer Area -->
<%@ include file="footer.jsp"%>
</body>
</html>