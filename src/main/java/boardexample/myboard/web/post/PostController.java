package boardexample.myboard.web.post;

import boardexample.myboard.domain.post.Post;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.session.SessionConst;
import boardexample.myboard.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/list")
    public String postList(Model model){
        List<Post> allPosts = postService.findAllPosts();
        model.addAttribute("posts", allPosts);
        return "post/postList";
    }

    @GetMapping("/{postId}")
    public String postView(@PathVariable("postId") Long postId, Model model){
        Post post = postService.findPost(postId);
        User user = post.getUser();
        model.addAttribute("post", post);
        model.addAttribute("user", user);

        return "post/postView";
    }

    @GetMapping("/{postId}/delete")
    public String postDelete(@PathVariable("postId") Long postId){
        postService.delete(postId);
        return "redirect:/post/list";
    }

    @GetMapping("/{postId}/edit")
    public String postUpdateForm(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.findPost(postId);
        model.addAttribute("form", post);
        return "post/postEditForm";
    }

    @PostMapping("/{postId}/edit")
    public String postUpdate(@PathVariable("postId") Long postId, @ModelAttribute("form")postUpdateForm form,
                             HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser =(User) session.getAttribute(SessionConst.LOGIN_USER);
        Long loginUserId = loginUser.getId();

        postService.updatePost(postId, loginUserId, form);
        return "redirect:/post/list";
    }

}
