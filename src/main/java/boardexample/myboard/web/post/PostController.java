package boardexample.myboard.web.post;

import boardexample.myboard.web.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
}
