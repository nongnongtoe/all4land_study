package boardexample.myboard.web.childvaccine;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.vachine.ChildVaccine;
import boardexample.myboard.web.Child.ChildRequest;
import boardexample.myboard.web.Child.ChildService;
import boardexample.myboard.web.user.UserSaveForm;
import boardexample.myboard.web.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ChildVaccineServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    ChildService childService;
    @Autowired
    ChildVaccineService vaccineService;


    @Test
    void 백신접종_저장(){
        Child child = setting();

        VaccineRequest request = VaccineRequest.builder()
                .inoculationDate(LocalDate.now())
                .hospital("병원")
                .memo("메모내용")
                .name("맞은 예방접종 이름")
                .build();

        Long vaccineId = vaccineService.save(child.getId(), request);
        ChildVaccine vaccine = vaccineService.findOne(vaccineId);

        assertThat(vaccine.getChild().getId()).isEqualTo(vaccineId);
        assertThat(vaccine.getHospital()).isEqualTo(request.getHospital());
        assertThat(vaccine.getMemo()).isEqualTo(request.getMemo());
        assertThat(vaccine.getName()).isEqualTo(request.getName());
        assertThat(vaccine.getInoculationDate()).isEqualTo(request.getInoculationDate());
    }

    @Test
    void 접종백신_수정(){
        Child child = setting();

        VaccineRequest request = VaccineRequest.builder()
                .inoculationDate(LocalDate.now())
                .hospital("병원")
                .memo("메모내용")
                .name("맞은 예방접종 이름")
                .build();

        Long vaccineId = vaccineService.save(child.getId(), request);
        String updateName = "수정된 예방접종";
        String memo="수정메모";
        request.setName(updateName);
        request.setMemo(memo);
        vaccineService.update(vaccineId, request);
        ChildVaccine vaccine = vaccineService.findOne(vaccineId);

        assertThat(vaccine.getMemo()).isEqualTo(memo);
        assertThat(vaccine.getName()).isEqualTo(updateName);

    }

    @Test
    void 접종백신_삭제(){
        Child child = setting();

        VaccineRequest request = VaccineRequest.builder()
                .inoculationDate(LocalDate.now())
                .hospital("병원")
                .memo("메모내용")
                .name("맞은 예방접종 이름")
                .build();

        Long vaccineId = vaccineService.save(child.getId(), request);
        vaccineService.delete(vaccineId);

        assertThatThrownBy(()->vaccineService.findOne(vaccineId)).isInstanceOf(IllegalStateException.class);



    }

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