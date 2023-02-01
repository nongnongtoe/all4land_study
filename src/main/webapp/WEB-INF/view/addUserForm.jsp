<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="icon" href="data:,">
    <script src="/js/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>

    <style>
        .field-error {
            border-color: #dc3545;
            color: #dc3545;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
    <div class="container-sm">
        <h4 class="mb-3">회원 정보 입력</h4>

        <form>
            <div>
                <label for="email">이메일</label>
                <input type="text" id="email"  class="form-control">
            </div>

            <div>
                <label for="password">비밀번호</label>
                <input type="password" id="password" class="form-control">
            </div>

            <div>
                <label for="passwordValid">비밀번호 재확인</label>
                <input type="password" id="passwordValid" class="form-control">
            </div>

            <div>
                <label for="phone">핸드폰</label>
                <input type="text" id="phone" class="form-control">
            </div>


            <hr class="my-4">

            <div>
                <input type="checkbox" id="adminCheck" class="form-check-input">
                <label for="adminCheck">관리자 권한 체크</label>
            </div>
        </form>
            <div class="d-grid gap-2">
                <button class="btn btn-primary" id="joinButton">회원 가입</button>
                <button type="button" class="btn btn-dark" onclick="location.href='/'">취소</button>
            </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>


<script>
$(document).ready(function() {
    $(document).on("click", "button[id='joinButton']", function() {
        var checked = $('[id=adminCheck]').is(':checked');
        let validCheck = valid();
        var formData = new FormData();
        formData.append('email', $("#email").val());
        formData.append('password', $("#password").val());
        formData.append('phone', $("#phone").val());
        formData.append('adminCheck',checked);
         if(validCheck){

            fetch('/userapi',{
                method : 'POST',
                cache: 'no-cache',
                body : formData
            }).then((response) => {
                let ok = response.ok;
                if(ok){
                    console.log("회원가입 성공!");
                }else{
                    alert("이미 회원가입된 아이디가 있습니다");
                }
            })
            .catch((error) => console.error(error.message));

         }


    });

});

function validInputtoAscii(inputString, tag) {
    if (inputString.length < 4 || inputString.length > 12) {
        alert("길이를 맞추어주세요!");
        return false;
    }

    for (let i = 0; i < inputString.length; i++) {
        let asci = inputString[i].charCodeAt(0);
        if ((asci > 32 && asci < 48) || (asci > 57 && asci < 65) || (asci > 90 && asci < 97)
            || (asci > 122 && asci < 126)) {
            alert(tag + "영어대소문자, 숫자만 사용가능합니다.(특수문자 사용 불가)");
            return false;
        } else if ((asci > 44031 && asci < 55203) || (asci > 12592 && asci < 12644)) {
            alert(tag + "영어대소문자, 숫자만 사용가능합니다.(한글 사용 불가)");
            return false;
        }
    }

    return true;
}


function valid() {
    var password = $("#password").val();
    var validPassword = $("#passwordValid").val();
    var email = $("#email").val();
    var phone = $("#phone").val();


    if (!email) {
            alert("email을 입력해주세요!");
            return false;
        } else if (email.indexOf("@") == -1 || email.indexOf(".") == -1
            || email.length <= 5) {
            alert("잘못된 이메일 형식입니다.")
            return false;
    }

    if (!password) {
        alert("비밀번호를 입력해 주세요!!!");
        return false;
    } else if (!validInputtoAscii(password, '비밀번호 ')) {
        return false;
    }

    if (!validPassword) {
        alert("비밀번호 확인을 입력해 주세요!!!");
        return false;
    } else if (password != validPassword) {
        alert("입력된 비밀번호가 서로 다릅니다.");
        return false;
    }


    if (!phone) {
        alert("휴대폰번호를 입력해주세요.");
        console.log("실패");
        return false;
    }

    return true;
}



</script>
</html>