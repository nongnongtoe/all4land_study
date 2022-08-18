package boardexample.myboard.web.allvaccine;


import boardexample.myboard.domain.allvaccine.AllVaccine;
import boardexample.myboard.domain.allvaccine.AllVaccineRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class allVaccineServiceTest {

    @Autowired allVaccineService allVaccineService;

    @Test
    public void 백신저장(){
        vaccineSaveForm saveForm = new vaccineSaveForm(1, 4, "백신1~4");
        Long save = allVaccineService.save(saveForm);
        AllVaccine findVaccine = allVaccineService.findVaccine(save);

        assertThat(findVaccine.getTitle()).isEqualTo(saveForm.getTitle());
        assertThat(findVaccine.getEndVaccine()).isEqualTo(saveForm.getEndVaccine());
        assertThat(findVaccine.getStartVaccine()).isEqualTo(saveForm.getStartVaccine());
    }

    @Test
    public void 모든백신보기(){
        vaccineSaveForm saveForm1 = new vaccineSaveForm(1, 4, "백신1");
        vaccineSaveForm saveForm2 = new vaccineSaveForm(1, 4, "백신2");
        vaccineSaveForm saveForm3 = new vaccineSaveForm(1, 4, "백신3");
        vaccineSaveForm saveForm4 = new vaccineSaveForm(1, 4, "백신4");
        Long save1 = allVaccineService.save(saveForm1);
        Long save2 = allVaccineService.save(saveForm2);
        Long save3 = allVaccineService.save(saveForm3);
        Long save4 = allVaccineService.save(saveForm4);

        List<AllVaccine> allVaccines = allVaccineService.vaccineList();

        assertThat(allVaccines.size()).isEqualTo(4);
    }

    @Test
    public void 백신업데이트(){
        vaccineSaveForm saveForm1 = new vaccineSaveForm(1, 4, "백신1");
        Long save = allVaccineService.save(saveForm1);
        AllVaccine vaccine = allVaccineService.findVaccine(save);
        updateVaccine update = new updateVaccine(2, 5, "백신up");
        allVaccineService.updateVaccine(save, update);

        assertThat(vaccine.getTitle()).isEqualTo(update.getTitle());
    }

}