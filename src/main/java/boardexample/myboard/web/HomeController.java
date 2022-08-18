package boardexample.myboard.web;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String loginHome(HttpServletRequest request, Model model){

        HttpSession session = request.getSession(false);

        if(session == null){
            return "home";
        }

        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);

        if(loginUser == null){
            return "home";
        }

        model.addAttribute("user",loginUser);

        return "mainHome";
    }
}
