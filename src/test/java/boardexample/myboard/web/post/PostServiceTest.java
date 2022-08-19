package boardexample.myboard.web.post;


import boardexample.myboard.domain.post.Post;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.user.UserSaveForm;
import boardexample.myboard.web.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Test
    public void 게시물_저장(){
        //유저 생성
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);
        User saveUser = userService.findUser(save);

        //게시판 작성
        postSaveForm form = postSaveForm.builder()
                .content("내용")
                .title("제목")
                .date(LocalDate.now())
                .build();

        Long savePost = postService.save(save, form);
        Post post = postService.findPost(savePost);

        assertThat(saveUser.getId()).isEqualTo(post.getUser().getId());
    }

    @Test
    public void 게시물_수정(){
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);
        User saveUser = userService.findUser(save);

        //게시판 작성
        postSaveForm form = postSaveForm.builder()
                .content("내용")
                .title("제목")
                .date(LocalDate.now())
                .build();

        Long savePost = postService.save(save, form);
        Post post = postService.findPost(savePost);

        postUpdateForm updateForm = new postUpdateForm(savePost, "제목수정", "내용 수정", LocalDate.now());
        postService.updatePost(savePost, save, updateForm);

        assertThat(post.getTitle()).isEqualTo(updateForm.getTitle());
        assertThat(post.getContent()).isEqualTo(updateForm.getContent());
        assertThat(post.getUpdateTable()).isEqualTo(updateForm.getUpdateTable());
        assertThat(post.getUser().getId()).isEqualTo(saveUser.getId());
    }

    @Test
    public void 게시판_수정_작성자와수정자가다를경우(){
        //사용자1 생성
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);

        //사용자2 생성
        String email1 = "6gnsgml6@kakao.com";
        String password1 = "1806";
        String phone1 = "010-1111-1111";
        UserSaveForm userSaveForm1 = new UserSaveForm(email1, password1, phone1);

        Long save1 = userService.save(userSaveForm1);

        //게시판 작성(사용자 1작성)
        postSaveForm form = postSaveForm.builder()
                .content("내용")
                .title("제목")
                .date(LocalDate.now())
                .build();
        Long savePost = postService.save(save, form);

        //사용자2가 사용자1 게시물 수정 요청
        postUpdateForm updateForm = new postUpdateForm(savePost, "제목수정", "내용 수정", LocalDate.now());

        assertThatThrownBy(()->postService.updatePost(savePost, save1, updateForm))
                .isInstanceOf(IllegalStateException.class);
    }


}