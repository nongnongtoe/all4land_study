package boardexample.myboard.web.Child;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.child.ChildRepository;
import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChildService {
    private final ChildRepository childRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(Long userId,ChildRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("로그인이 필요합니다."));
        request.setUser(user);
        Child saveChild = childRepository.save(request.toEntity());
        saveChild.setUser(request.getUser());
        return saveChild.getId();
    }

    @Transactional
    public void update(Long childId, String name){
        Child child = findOne(childId);
        child.updateChild(name);
    }

    @Transactional
    public void delete(Long childId){
        childRepository.deleteById(childId);
    }

    public Child findOne(Long childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalStateException("사용할 수 없는 사용자입니다"));
        return child;
    }

    public List<Child> findAllChild(){
        return childRepository.findAll();
    }

    public Child findName(String name){
        return childRepository.findByName(name);
    }


}
