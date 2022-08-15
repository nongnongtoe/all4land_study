package boardexample.myboard.web.user;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void 회원가입(){
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);
        User saveUser = userService.findUser(save);

        assertThat(saveUser.getEmail()).isEqualTo(email);
    }

    @Test
    public void 회원업데이트(){
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);

        UserUpdateRequest request = new UserUpdateRequest("1807", "010-2222-2222");
        userService.updateUser(save, request);

        User user = userService.findUser(save);

        assertThat(user.getPassword()).isEqualTo(request.getPassword());
    }

    /*@Test
    public void 중복회원가입(){
        //given
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);


        //when
        Long save1 = userService.save(userSaveForm);

        assertThat(userService.save(userSaveForm)).isInstanceOf(IllegalStateException.class);

    }*/

}