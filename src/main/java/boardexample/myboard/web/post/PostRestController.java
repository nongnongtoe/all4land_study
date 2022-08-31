package boardexample.myboard.web.post;


import boardexample.myboard.domain.post.Post;
import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/postapi")
public class PostRestController {
    private final PostService postService;

    @GetMapping("/{postId}")
    public PostResponseDto findById(@PathVariable("postId") Long id){
        return postService.findByPostDto(id);
    }

    @GetMapping
    public Result findAllPost(){
        List<PostResponseDto> postResponseDtoList = postService.allPostDto();
        return new Result<>(postResponseDtoList);
    }
}
