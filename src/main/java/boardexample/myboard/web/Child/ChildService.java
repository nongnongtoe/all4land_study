package boardexample.myboard.web.Child;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.child.ChildRepository;
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
public class ChildService {
    private final ChildRepository childRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(Long userId,ChildRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("해당 사용자가 존재하지 않습니다."));
        request.setUser(user);
        Child saveChild = childRepository.save(request.toEntity());
        saveChild.setUser(request.getUser());
        return saveChild.getId();
    }

    @Transactional
    public void update(Long childId, String name, Long userId){
        User loginUser = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("해당 사용자가 존재하지 않습니다."));
        Child child = findOne(childId);
        validate(loginUser, child.getUser());
        child.updateChild(name);
    }

    @Transactional
    public void delete(Long childId, Long userId){
        User loginUser = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("해당 사용자가 존재하지 않습니다."));
        User childUser = findOne(childId).getUser();
        validate(loginUser, childUser);
        childRepository.deleteById(childId);
    }

    public Child findOne(Long childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalStateException("사용할 수 없는 사용자입니다"));
        return child;
    }

    public ChildResponse findById(Long childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalStateException("사용할 수 없는 사용자입니다"));
        return new ChildResponse(child);
    }

    public List<Child> findAllChild(){
        return childRepository.findAll();
    }

    public List<ChildResponse> findByUserAllChild(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("로그인이 필요합니다."));
        List<Child> children = childRepository.findByUser(user);
        List<ChildResponse> childResponseList = new ArrayList<>();

        for(Child child : children){
            ChildResponse dto = new ChildResponse(child);
            childResponseList.add(dto);
        }

        return childResponseList;
    }

    public Child findName(String name){
        return childRepository.findByName(name);
    }

    private void validate(User loginUser, User childUser) {
        if(loginUser.getId() != childUser.getId()){
            throw new IllegalStateException("로그인 사용자와 작성 사용자가 다릅니다.");
        }
    }


}
