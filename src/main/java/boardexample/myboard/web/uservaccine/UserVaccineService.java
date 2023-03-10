package boardexample.myboard.web.uservaccine;

import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import boardexample.myboard.domain.vachine.MyVaccine;
import boardexample.myboard.domain.vachine.MyVaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserVaccineService {
    private final MyVaccineRepository myVaccineRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(Long userId, MyVaccineRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("해당 사용자 없습니다."));
        request.setUser(user);
        MyVaccine myVaccine = myVaccineRepository.save(request.toEntity());
        myVaccine.setUser(user);
        return myVaccine.getId();
    }

    @Transactional
    public void update(Long vaccineId, MyVaccineRequest request, Long userId){
        MyVaccine myVaccine = getMyVaccine(vaccineId);
        User myVaccineUser = myVaccine.getUser();
        User loginUser = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("해당 사용자 없습니다."));
        myValidate(myVaccineUser, loginUser);
        myVaccine.updateMyVaccine(request.getName(), request.getInoculationDate(), request.getMemo(), request.getHospital());
    }

    @Transactional
    public void delete(Long vaccineId, Long userId){
        MyVaccine myVaccine = getMyVaccine(vaccineId);
        User myVaccineUser = myVaccine.getUser();
        User loginUser = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("해당 사용자 없습니다."));
        myValidate(myVaccineUser, loginUser);
        myVaccineRepository.deleteById(vaccineId);
    }

    public MyVaccineResponse findById(Long vaccineId){
        MyVaccine myVaccine = getMyVaccine(vaccineId);
        return new MyVaccineResponse(myVaccine);
    }

    public List<MyVaccineResponse> findByUserAllVaccine(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("해당 사용자 없습니다."));
        List<MyVaccine> vaccine = myVaccineRepository.findByUser(user);
        List<MyVaccineResponse> vaccineResponses = new ArrayList<>();
        for(MyVaccine myVaccine : vaccine){
            MyVaccineResponse dto = new MyVaccineResponse(myVaccine);
            vaccineResponses.add(dto);
        }

        return vaccineResponses;
    }

    private void myValidate(User myVaccineUser, User loginUser) {
        if(myVaccineUser.getId() != loginUser.getId()){
            throw new IllegalStateException("로그인한 사용자와 작성 사용자가 다릅니다.");
        }
    }

    private MyVaccine getMyVaccine(Long vaccineId) {
        MyVaccine myVaccine = myVaccineRepository.findById(vaccineId).orElseThrow(() -> new IllegalStateException("해당 백신이 없습니다.,"));
        return myVaccine;
    }




}
