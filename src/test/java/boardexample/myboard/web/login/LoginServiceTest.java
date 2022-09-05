package boardexample.myboard.web.login;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import boardexample.myboard.web.user.UserSaveForm;
import boardexample.myboard.web.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class LoginServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

  /*  @Test
    void 로그인(){
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);
        User saveUser = userService.findUser(save);

        User loginUser = loginService.loginUser(email, password);

        Assertions.assertThat(saveUser.getId()).isEqualTo(loginUser.getId());

    }
*/
}