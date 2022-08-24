package boardexample.myboard.web.Child;


import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.web.user.UserSaveForm;
import boardexample.myboard.web.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ChildServiceTest {
    @Autowired
    ChildService childService;
    @Autowired
    UserService userService;

    @Test
    public void 자식생성(){
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);
        User user = userService.findUser(save);

        ChildRequest request = new ChildRequest("자식1");

        Long childId = childService.save(save, request);
        Child child = childService.findOne(childId);

        //연관관계 세팅 메서드 확인 테스트
        List<Child> children = user.getChildren();
        for (Child child1 : children) {
            System.out.println("child1 = " + child1.getName());
        }

        assertThat(child.getName()).isEqualTo(request.getName());
        assertThat(child.getUser().getId()).isEqualTo(save);
    }

    @Test
    public void 업데이트(){
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);
        User user = userService.findUser(save);

        ChildRequest request = new ChildRequest("자식1");

        Long childId = childService.save(save, request);
        Child child = childService.findOne(childId);
        String updateName = "수정한 이름입니다.";
        child.updateChild(updateName);

        assertThat(child.getName()).isEqualTo(updateName);
    }

    @Test
    public void 삭제(){
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);
        User user = userService.findUser(save);

        ChildRequest request = new ChildRequest("자식1");

        Long childId = childService.save(save, request);
        childService.delete(childId);

        assertThatThrownBy(()->childService.findOne(childId)).isInstanceOf(IllegalStateException.class);

    }


}