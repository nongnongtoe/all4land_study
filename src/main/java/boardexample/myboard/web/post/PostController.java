package boardexample.myboard.web.post;

import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import boardexample.myboard.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/add")
    public String postAddForms(@ModelAttribute("form")postSaveForm form){
        return "post/postAddForm";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute("form")postSaveForm form, HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);

        postService.save(loginUser.getId(), form);

        return "redirect:/";
    }

}
