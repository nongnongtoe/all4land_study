package boardexample.myboard.web.childfamilyhistory;


import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.familydiseasehistory.ChildFamilyHistory;
import boardexample.myboard.web.Child.ChildRequest;
import boardexample.myboard.web.Child.ChildService;
import boardexample.myboard.web.user.UserSaveForm;
import boardexample.myboard.web.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ChildFamilyHistoryServiceTest {
    @Autowired
    ChildFamilyHistoryService childFamilyHistoryService;
    @Autowired
    UserService userService;
    @Autowired
    ChildService childService;

    @Test
    public void 가족력_저장(){
        Child child = setting();
        ChildFamilyHistoryRequest request = new ChildFamilyHistoryRequest("가족력", "내용", child);
        Long save = childFamilyHistoryService.save(child.getId(), request);
        ChildFamilyHistoryResponse findOne = childFamilyHistoryService.findById(save);
        ChildFamilyHistory history = child.getHistoryList().get(0);

        assertThat(findOne.getName()).isEqualTo(request.getName());
        assertThat(request.getChild()).isEqualTo(history.getChild());
    }

    @Test
    public void 가족력_업데이트(){
        Child child = setting();
        ChildFamilyHistoryRequest request = new ChildFamilyHistoryRequest("가족력", "내용", child);
        Long save = childFamilyHistoryService.save(child.getId(), request);
        ChildFamilyHistory one = childFamilyHistoryService.findOne(save);
        one.updateChildFamilyHistory("수정된가족력", "수정된내용", child);
        assertThat(one.getMemo()).isEqualTo("수정된내용");
    }

    @Test
    public void 가족력_삭제(){
        Child child = setting();
        ChildFamilyHistoryRequest request = new ChildFamilyHistoryRequest("가족력", "내용", child);
        Long save = childFamilyHistoryService.save(child.getId(), request);
        childFamilyHistoryService.delete(save);
        assertThatThrownBy(()->childFamilyHistoryService.findOne(save)).isInstanceOf(IllegalStateException.class);    }


    private Child setting() {
        String email = "7gnsgml7@kakao.com";
        String password = "1806";
        String phone = "010-1111-1111";
        UserSaveForm userSaveForm = new UserSaveForm(email, password, phone);

        Long save = userService.save(userSaveForm);

        ChildRequest request = new ChildRequest("자식1");

        Long childId = childService.save(save, request);
        return childService.findOne(childId);
    }
}