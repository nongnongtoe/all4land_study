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

    <title>가족력 페이지</title>
</head>
<body>
<!-- 헤더 영역 -->
<%@ include file="header.jsp" %>
<!--콘테이너 영역-->
<div style="margin-left: 17%; margin-right: 17%">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">병명</th>
            <th scope="col">비고</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${historyList}" var="historyList">
            <tr>
                <td>${historyList.id}</td>
                <td><button  data-bs-toggle="modal" style="border: none; background-color:transparent;"
                                                            data-bs-target="#exampleModal" data-bs-id=${historyList.id} data-bs-name=${historyList.name} data-bs-memo=${historyList.memo}
                                                            >${historyList.name}</button></td>
                <td>${historyList.memo}</td>

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
        <form id="testForm" method="post" action="/myFamily/update" name="historyList">
           <div class="mb-3">
            <label for="historyList-id" class="col-form-label">Index:</label>
            <input type="number" class="form-control" id="historyList-id" name="id" readonly>
          </div>


          <div class="mb-3">
            <label for="historyList-name" class="col-form-label">병명:</label>
            <input type="text" class="form-control" id="historyList-name" name="name">
          </div>
          <div class="mb-3">
            <label for="historyList-memo" class="col-form-label">비고:</label>
            <input type="text" class="form-control" id="historyList-memo" name="memo">
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
<button type="button" class="btn btn-primary btn-sm" onclick="location.href='/myFamily/add'" style="margin-left: 80%">
    글쓰기
</button>
<!-- 푸터 영역 -->
<%@ include file="footer.jsp" %>
</body>
<script>
var exampleModal = document.getElementById('exampleModal')
exampleModal.addEventListener('show.bs.modal', function (event) {
  // Button that triggered the modal
  var button = event.relatedTarget

  //  data-bs-* attributes 모달 버튼에서 데이터값 가져오기 data-bs-name
  var recipient = button.getAttribute('data-bs-title')
  var name = button.getAttribute('data-bs-name')
  var memo = button.getAttribute('data-bs-memo')
  var id = button.getAttribute('data-bs-id')


  var modalTitle = exampleModal.querySelector('.modal-title')
  // 모달창 데이터 입력 화면 아이디로 가져오기
  var modalIdInput = exampleModal.querySelector('#historyList-id');
  var modalNameInput = exampleModal.querySelector('#historyList-name');
  var modalMemoInput = exampleModal.querySelector('#historyList-memo');

  modalTitle.textContent = '병명: ' + name
  modalNameInput.value = name;
  modalMemoInput.value = memo;
  modalIdInput.value = id;
})

function deleteFn(){
    var id = $("#historyList-id").val();
    var link = "/myFamily/" + id + "/delete";
    location.href=link;
}
</script>
</html>