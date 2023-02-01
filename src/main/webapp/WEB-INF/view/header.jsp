<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                <use xlink:href="#bootstrap"/>
            </svg>
        </a>

        <ul class="nav nav-tabs">
            <li class="nav-item"><a href="#" class="nav-link px-2 link-secondary">Home</a></li>&nbsp;&nbsp;&nbsp;
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                   aria-expanded="false">가족력</a>&nbsp;&nbsp;&nbsp;
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/myFamily">내 가족력</a>&nbsp;&nbsp;&nbsp;
                    <a class="dropdown-item" href="#">need to modify</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                   aria-expanded="false">Vaccin</a>&nbsp;&nbsp;&nbsp;
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">need to modify</a>&nbsp;&nbsp;&nbsp;
                    <a class="dropdown-item" href="#">need to modify</a>
                </div>
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
        <form action="/logout" method="post">
            <button type="submit" class="btn btn-outline-primary me-2" onclick="location.href='/logout'">LogOut</button>
        </form>
        </div>
    </header>
</div>
</body>
</html>