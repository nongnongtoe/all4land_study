package boardexample.myboard.web.login;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class LoginRestController {
    private final LoginService loginService;
    @PostMapping("/loginapi")
    public String login(@Validated @RequestBody LoginForm form, BindingResult result, HttpServletRequest request){

        User user = loginService.loginUser(form);
        if(user == null){
            result.reject("loginFail", "해당 아이디 비밀번호가 없습니다.");
            throw new IllegalStateException("오류 발생");
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, user);
        return "login";

    }

    @PostMapping("/logoutapi")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            return "logout";
        }else{
            return "이미 로그아웃 되었습니다.";
        }


    }
}
