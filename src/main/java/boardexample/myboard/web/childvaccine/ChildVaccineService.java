package boardexample.myboard.web.childvaccine;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.child.ChildRepository;
import boardexample.myboard.domain.vachine.ChildVaccine;
import boardexample.myboard.domain.vachine.ChildVaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChildVaccineService {
    private final ChildRepository childRepository;
    private final ChildVaccineRepository vaccineRepository;

    @Transactional
    public Long save(Long childId, VaccineRequest request){
        Child getChild = getchild(childId);
        request.setChild(getChild);
        ChildVaccine saveVaccine = vaccineRepository.save(request.toEntity());
        saveVaccine.setChild(getChild);
        return saveVaccine.getId();
    }

    @Transactional
    public void update(Long vaccineId, VaccineRequest request, Long childId){
        ChildVaccine vaccine = findOne(vaccineId);
        Child getChild = getchild(childId);
        request.setChild(getChild);
        validateChild(request, vaccine);
        vaccine.updateChildVaccine(request.getName(), request.getInoculationDate(), request.getMemo(), request.getHospital(), request.getChild());
    }

    @Transactional
    public void delete(Long vaccineId){
        vaccineRepository.deleteById(vaccineId);
    }


    public List<VaccineResponse> findByChildAllVaccine(Long childId){
        Child child = getchild(childId);
        List<ChildVaccine> childVaccineList = vaccineRepository.findByChild(child);
        List<VaccineResponse> vaccineResponseList = new ArrayList<>();
        for (ChildVaccine vaccine : childVaccineList) {
            VaccineResponse dto = new VaccineResponse(vaccine);
            vaccineResponseList.add(dto);
        }


        return vaccineResponseList;
    }

    public VaccineResponse findById(Long vaccineId){
        ChildVaccine vaccine = vaccineRepository.findById(vaccineId).orElseThrow(() -> new IllegalStateException("??????????????? ????????? ????????????."));
        return new VaccineResponse(vaccine);
    }


    public ChildVaccine findOne(Long vaccineId){
        return vaccineRepository.findById(vaccineId).orElseThrow(()->new IllegalStateException("??????????????? ????????? ????????????."));
    }

    private Child getchild(Long childId) {
        return childRepository.findById(childId).orElseThrow(() -> new IllegalStateException("???????????? ????????? ????????????."));
    }

    private void validateChild(VaccineRequest request, ChildVaccine vaccine) {
        if(request.getChild() != vaccine.getChild()){
            throw new IllegalStateException("?????? ????????? ???????????????.");
        }
    }


}
