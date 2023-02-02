<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <title>백신 검색</title>
    <script src="/js/jquery.min.js"></script>

    </head>
<body>
<%@ include file="header.jsp"%>

<div class="container-sm">
<form class="form-signin">
    <!-- Modal -->
    <div class="modal modal-dialog fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">접종 예정 백신 종류</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body ">
            <table class="table test">
                    <tr>
                        <th>백신 이름</th>
                        <th>접종 시작 월</th>
                        <th>접종 종료 월</th>
                    </tr>

                    <tbody id="table1">

                    </tbody>
                </table>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
</div>
  <div class="text-center mb-4">
    <img class="mb-4" src="/images/logo.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">접종 관리</h1>
    <p>아이의 생일을 통해 다음 접종 목록을 알 수 있습니다</p>
  </div>


  <div class="form-label-group w-25 text-center" style= "float:none; margin:0 auto" align="center">
    <input type="date" id="inputBirth" name="birth" class="form-control "  placeholder="아이의 생년월일" required autofocus>
  </div>


  <div class="text-center">
  <button id="searchBtn"class="btn btn-lg btn-primary btn-block  my-4  w-25 " style= "float:none; margin:0 auto" align="center" type="button" data-toggle="modal" data-target="#exampleModal">검색</button>
  </div>


</form>


<%@ include file="footer.jsp"%>
</body>

<script>
$(document).ready(function() {
    $(document).on("click", "button[id='searchBtn']", function(){
        var formData = new FormData();
        formData.append('birth', $("#inputBirth").val());
        fetch('/vaccineApi/searchVaccine',{
                        method : 'post',
                        cache: 'no-cache',
                        body : formData
        }).then(response =>  response.json())
        .then(data => { console.log(data)
            popup(data);

        })
    });
})

function popup(data){
    function create_td(value) {
        return '<td>' + value + '</td>'
    }

    console.dir(data)

    var table = document.getElementById('table1')

        for (var i=0; i < data.length; i++)
        {
            const title = '' + data[i]['title']
            console.log(title)
            console.log(data[i].title)

            var row = '<tr>' + create_td(data[i].title) + create_td(data[i].startVaccine) + create_td(data[i].endVaccine) + '</tr>'

            table.innerHTML += row
        }

}





</script>
</html>