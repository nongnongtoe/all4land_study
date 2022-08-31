package boardexample.myboard.web.userfamilyhistory;

import boardexample.myboard.domain.familydiseasehistory.MyFamilyHistory;
import boardexample.myboard.domain.familydiseasehistory.MyFamilyHistoryRepository;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserFamilyHistoryService {
    private final UserRepository userRepository;
    private final MyFamilyHistoryRepository familyHistoryRepository;

    @Transactional
    public Long save(UserFamilyRequest userFamilyRequest){
        Long userId = userFamilyRequest.getUser().getId();
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("사용자를 찾을수 없습니다."));
        MyFamilyHistory myFamilyHistory = familyHistoryRepository.save(userFamilyRequest.toEntity());
        myFamilyHistory.setUser(user);
        return myFamilyHistory.getId();
    }

    @Transactional
    public void update(Long familyId,UserFamilyRequest userFamilyRequest){
        MyFamilyHistory myFamilyHistory = getMyFamilyHistory(familyId);
        myFamilyHistory.updateMyFamilyHistory(userFamilyRequest.getName(), userFamilyRequest.getMemo());
    }

    @Transactional
    public void delete(Long familyId){
        familyHistoryRepository.deleteById(familyId);
    }

    public UserFamilyResponse findById(Long familyHistoryId){
        MyFamilyHistory myFamilyHistory = getMyFamilyHistory(familyHistoryId);
        return new UserFamilyResponse(myFamilyHistory);
    }

    public List<UserFamilyResponse> findByUserAllFamilyHistory(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("사용자를 찾을수 없습니다."));
        List<MyFamilyHistory> myFamilyHistories = familyHistoryRepository.findByUser(user);
        List<UserFamilyResponse> familyResponseList = new ArrayList<>();

        for(MyFamilyHistory myFamilyHistory : myFamilyHistories){
            UserFamilyResponse dto = new UserFamilyResponse(myFamilyHistory);
            familyResponseList.add(dto);
        }

        return familyResponseList;
    }

    private MyFamilyHistory getMyFamilyHistory(Long familyHistoryId) {
        MyFamilyHistory myFamilyHistory = familyHistoryRepository.findById(familyHistoryId).orElseThrow(() -> new IllegalStateException("해당 게시물이 없습니다."));
        return myFamilyHistory;
    }


}
