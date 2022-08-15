package boardexample.myboard.web.user;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveForm userSaveForm){
        validated(userSaveForm);

        return userRepository.save(userSaveForm.toEntity()).getId();
    }

    @Transactional
    public void updateUser(Long id, UserUpdateRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당회원이업습니다. " + id));

        user.updateUser(request.getPassword(), request.getPassword());
    }

    public User findUser(Long id){
        return userRepository.findById(id).orElseThrow(()->new IllegalStateException("존재하지 않습니다."));
    }




    private void validated(UserSaveForm userSaveForm) {
        userRepository.findByEmail(userSaveForm.getEmail())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }


}
