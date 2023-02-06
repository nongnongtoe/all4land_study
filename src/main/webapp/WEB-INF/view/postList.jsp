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
    <link rel="stylesheet" href="/css/bootstrap.css">

    <title>공지사항</title>
</head>
<body>
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<div style="margin-left: 17%; margin-right: 17%">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">제목</th>
            <th scope="col">내용</th>
            <th scope="col">작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${posts}" var="posts">
            <tr>
                <td><button  data-bs-toggle="modal" style="border: none; background-color:transparent;"
                    data-bs-target="#exampleModal" data-bs-id=${posts.id} data-bs-title=${posts.title} data-bs-content=${posts.content}
                    data-bs-date=${posts.date}>${posts.title}</button></td>
                <td>${posts.content}</td>
                <td>${posts.date}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form id="testForm" method="post" action="/post/edit" name="posts">
           <div class="mb-3">
               <input type="number" class="form-control" id="posts-id" name="id" readonly>
           </div>

          <div class="mb-3">
            <label for="posts-title" class="col-form-label">제목:</label>
            <input type="text" class="form-control" id="posts-title" name="title">
          </div>
          <div class="mb-3">
            <label for="posts-content" class="col-form-label">내용:</label>
            <input type="text" class="form-control" id="posts-content" name="content">
          </div>
          <div class="mb-3">
            <label for="posts-date" class="col-form-label">작성일:</label>
            <input type="date" class="form-control" id="posts-date" name="updateTable">
          </div>

        </form>
      </div>
      <div class="modal-footer">
        <button type="submit" form="testForm" class="btn btn-secondary">수정</button>
        <button type="button" class="btn btn-primary" onclick="deleteFn()">삭제</button>
      </div>
    </div>
  </div>
</div>



<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>


<script>
var exampleModal = document.getElementById('exampleModal')
exampleModal.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget

  //  data-bs-* attributes 모달 버튼에서 데이터값 가져오기 data-bs-content
  var title = button.getAttribute('data-bs-title')
  var content = button.getAttribute('data-bs-content')
  var date = button.getAttribute('data-bs-date')
  var id = button.getAttribute('data-bs-id')



  var modalTitle = exampleModal.querySelector('.modal-title')
  // 모달창 데이터 입력 화면 아이디로 가져오기
  var modalTitleInput = exampleModal.querySelector('#posts-title');
  var modalContentInput = exampleModal.querySelector('#posts-content');
  var modalDateInput = exampleModal.querySelector('#posts-date');
  var modalIdInput = exampleModal.querySelector('#posts-id');

  modalTitle.textContent = '공지 제목 : ' + title
  modalIdInput.value = id;
  modalContentInput.value = content;
  modalDateInput.value = date;
  modalTitleInput.value = title;
})

function deleteFn(){
    var id = $("#posts-id").val();
    var link = "/post/" + id + "/delete";
    location.href=link;
}
</script>
