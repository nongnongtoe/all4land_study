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

    <title>백신 입력 페이지</title>
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
            <th scope="col">Title</th>
            <th scope="col"><button type="button" class="btn btn-primary btn-sm" onclick="location.href='/vaccine/add'" style="margin-left: 73%">
                                글쓰기
                            </button></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vaccines}" var="vaccines">
            <tr>
                <td>${vaccines.id}</td>
                <td colspan="2"><button  data-bs-toggle="modal" style="border: none; background-color:transparent;"
                    data-bs-target="#exampleModal" data-bs-title=${vaccines.title} data-bs-start=${vaccines.startVaccine}
                    data-bs-end=${vaccines.endVaccine} data-bs-id=${vaccines.id}>
                    ${vaccines.title}</button></td>

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
        <form id="testForm" method="post" action="/vaccine/edit" name="vaccine">
           <div class="mb-3">
            <input type="hidden" class="form-control" id="vaccine-id" name="id" readonly>
          </div>

          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">백신 이름:</label>
            <input type="text" class="form-control" id="recipient-name" name="title">
          </div>
          <div class="mb-3">
            <label for="vaccine-start" class="col-form-label">백신 접종 시작:</label>
            <input type="text" class="form-control" id="vaccine-start" name="startVaccine">
          </div>
          <div class="mb-3">
            <label for="vaccine-end" class="col-form-label">백신 접종 종료:</label>
            <input type="text" class="form-control" id="vaccine-end" name="endVaccine">
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

  //  data-bs-* attributes 모달 버튼에서 데이터값 가져오기 data-bs-start
  var recipient = button.getAttribute('data-bs-title')
  var start = button.getAttribute('data-bs-start')
  var end = button.getAttribute('data-bs-end')
  var id = button.getAttribute('data-bs-id')


  var modalTitle = exampleModal.querySelector('.modal-title')
  // 모달창 데이터 입력 화면 아이디로 가져오기
  var modalTitleInput = exampleModal.querySelector('#recipient-name');
  var modalStartInput = exampleModal.querySelector('#vaccine-start');
  var modalEndInput = exampleModal.querySelector('#vaccine-end');
  var modalIdInput = exampleModal.querySelector('#vaccine-id');

  modalTitle.textContent = '백신 이름 : ' + recipient
  modalTitleInput.value = recipient;
  modalStartInput.value = start;
  modalEndInput.value = end;
  modalIdInput.value = id;
})

function deleteFn(){
    var id = $("#vaccine-id").val();
    var link = "/vaccine/" + id + "/delete";
    location.href=link;
}
</script>
</html>