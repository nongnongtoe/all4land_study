package boardexample.myboard.web.allvaccine;

import boardexample.myboard.domain.allvaccine.AllVaccine;
import boardexample.myboard.domain.allvaccine.AllVaccineRepository;
import boardexample.myboard.web.allvaccine.dto.updateVaccineForm;
import boardexample.myboard.web.allvaccine.dto.vaccineSaveForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class allVaccineService {
    private final AllVaccineRepository allVaccineRepository;

    @Transactional
    public Long save(vaccineSaveForm vaccine){
        return allVaccineRepository.save(vaccine.toEntity()).getId();
    }

    public List<AllVaccine> vaccineList(){
        return allVaccineRepository.findAll();
    }

    public AllVaccine findVaccine(Long id){
        return allVaccineRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("찾으려는 백신이 없습니다."));
    }

    @Transactional
    public void updateVaccine(Long id, updateVaccineForm updateVaccine){
        AllVaccine vaccine = findVaccine(id);
        vaccine.updateAllVaccine(updateVaccine.getStartVaccine(), updateVaccine.getEndVaccine(),
                updateVaccine.getTitle());
    }

    @Transactional
    public void deleteVaccine(Long id){
        AllVaccine vaccine = findVaccine(id);
        allVaccineRepository.delete(vaccine);
    }



}
