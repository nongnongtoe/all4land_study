package boardexample.myboard.web.allvaccine;

import boardexample.myboard.domain.allvaccine.AllVaccine;
import boardexample.myboard.domain.allvaccine.AllVaccineRepository;
import boardexample.myboard.web.allvaccine.dto.updateVaccineForm;
import boardexample.myboard.web.allvaccine.dto.vaccineSaveForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void updateVaccine(updateVaccineForm updateVaccine){
        Long id = updateVaccine.getId();
        AllVaccine vaccine = findVaccine(id);
        vaccine.updateAllVaccine(updateVaccine.getStartVaccine(), updateVaccine.getEndVaccine(),
                updateVaccine.getTitle());
    }

    @Transactional
    public void deleteVaccine(Long id){
        AllVaccine vaccine = findVaccine(id);
        allVaccineRepository.delete(vaccine);
    }

    /**
     * RestAPI
     */
    public allVaccineResponse findById(Long vaccineId){
        AllVaccine vaccine = findVaccine(vaccineId);
        return new allVaccineResponse(vaccine);
    }

    public List<allVaccineResponse> findAllVaccine(){
        List<AllVaccine> vaccineList = allVaccineRepository.findAll();
        List<allVaccineResponse> list = new ArrayList<>();

        for (AllVaccine vaccine : vaccineList){
            allVaccineResponse dto = new allVaccineResponse(vaccine);
            list.add(dto);
        }
        return list;
    }

    public List<allVaccineResponse> findBySearchVaccineList(RequestVaccineDto requestVaccineDto){
        LocalDate birth = requestVaccineDto.getBirth();
        LocalDate today = LocalDate.now();
        int findBirth = (int) ChronoUnit.MONTHS.between(birth, today);

        return allVaccineRepository.findBySearchVaccine(findBirth).stream().map(v -> new allVaccineResponse(v)).collect(Collectors.toList());
    }



}
