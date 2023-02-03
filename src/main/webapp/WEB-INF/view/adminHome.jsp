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
    <script src="js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="/bootstrap.css">
    <style>
        #notice-tab-wrap {
            margin-left: 65%;
            margin-right: 15%;
            margin-top: -300px;
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
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<!-- 콘테이너.슬라이드 영역 -->
<div id="carouselExampleIndicators" class="carousel slide" style="width: 500px; height: 300px;  margin-left:300px;"
     data-ride="carousel">
    <ol class="carousel-indicators"style="position: absolute; bottom: -50px;  align :center;">
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
<!-- 콘테이너.게시판 영역 -->
<div id="notice-tab-wrap">
    <h3 class="sec-tit-1">관리자 기능</h3>
    <button type="button" class="btn btn-outline-primary" onclick="location.href='/post/add'">공지사항 작성</button>
    <button type="button" class="btn btn-outline-primary" onclick="location.href='/vaccine/list'">백신 입력</button>
</div>
<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>
</html>