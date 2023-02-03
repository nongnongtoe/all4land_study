package boardexample.myboard.web.childfamilyhistory;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.child.ChildRepository;
import boardexample.myboard.domain.familydiseasehistory.ChildFamilyHistory;
import boardexample.myboard.domain.familydiseasehistory.ChildFamilyHistoryRepository;
import boardexample.myboard.web.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChildFamilyHistoryService {
    private final ChildRepository childRepository;
    private final ChildFamilyHistoryRepository familyHistoryRepository;

    @Transactional
    public Long save(Long childId, ChildFamilyHistoryRequest request) {
        Child child = childRepository.findById(childId).orElseThrow(() -> new IllegalStateException("자식을 찾을수없습니다."));
        request.setChild(child);
        ChildFamilyHistory history = familyHistoryRepository.save(request.toEntity());
        history.setChild(child);
        return history.getId();
    }

    @Transactional
    public void update(Long id, ChildFamilyHistoryRequest request) {
        ChildFamilyHistory history = findOne(id);
        history.updateChildFamilyHistory(request.getName(), request.getMemo(), request.getChild());
    }

    @Transactional
    public void delete(Long id) {
        familyHistoryRepository.deleteById(id);
    }

    public ChildFamilyHistoryResponse findById(Long id) {
        ChildFamilyHistory history = familyHistoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("찾으려는 게시물이 없습니다."));
        return new ChildFamilyHistoryResponse(history);
    }

    public ChildFamilyHistory findOne(Long id) {
        return familyHistoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("찾으려는 게시물이 없습니다."));
    }

    public List<ChildFamilyHistoryResponse> findByChildAllHistory() {
        List<ChildFamilyHistory> all = familyHistoryRepository.findAll();
        List<ChildFamilyHistoryResponse> responseList = new ArrayList<>();
        for (ChildFamilyHistory history : all) {
            ChildFamilyHistoryResponse dto = new ChildFamilyHistoryResponse(history);
            responseList.add(dto);
        }

        return responseList;
    }

    public List<ChildFamilyHistory> findByChildIdHistoryList(Long childId){
        Child child = childRepository.findById(childId).orElseThrow(() -> new IllegalStateException("자식을 찾을수없습니다."));

        List<ChildFamilyHistory> childList = familyHistoryRepository.findByChild(child);

        return childList;
    }
}
