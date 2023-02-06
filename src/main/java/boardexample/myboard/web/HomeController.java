package boardexample.myboard.web;


import boardexample.myboard.domain.post.Post;
import boardexample.myboard.domain.user.Role;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.post.PostResponseDto;
import boardexample.myboard.web.post.PostService;
import boardexample.myboard.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final PostService postService;

    //@GetMapping("/")
    public String home(){
        return "home";
    }


    //@GetMapping("/")
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

    @GetMapping("/")
    public String loginSessionAttribute(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) User loginUser,
                                        Model model){
        List<Post> limitPosts = postService.findLimitPosts();
        log.info("확인");
        if(loginUser == null){
            model.addAttribute("postList", limitPosts);
            return "index";
        }else if(loginUser.getRole() == Role.ADMIN){

            model.addAttribute("user", loginUser);
            return "adminHome";
        }else{

            model.addAttribute("postList", limitPosts);
            return "mainHome";
        }

    }
}
