package boardexample.myboard.web.login;

import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import boardexample.myboard.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("user") LoginForm user){
        return "login/loginForm";
    }


    //@PostMapping("/login")
    //세션 없이 로그인을 진행
    public String login(@Validated @ModelAttribute("user") LoginForm user, BindingResult result){
        if(result.hasErrors()){
            return "login/loginForm";
        }

        User loginUser = loginService.loginUser(user.getEmail(), user.getPassword());

        if(loginUser==null){
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }


        return "redirect:/";
    }

    @PostMapping("/login")
    public String SessionLogin(@Validated @ModelAttribute("user") LoginForm user, BindingResult result
                               , HttpServletRequest request){
        if(result.hasErrors()){
            return "login/loginForm";
        }

        User loginUser = loginService.loginUser(user.getEmail(), user.getPassword());

        if(loginUser==null){
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.LOGIN_USER, loginUser);


        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        return "redirect:/";
    }
}
