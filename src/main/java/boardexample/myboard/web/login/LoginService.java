package boardexample.myboard.web.login;

import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {
    private final UserRepository userRepository;


    public User loginUser(LoginForm form){
        return userRepository.findByEmail(form.getEmail())
                .filter(u -> u.getPassword().equals(form.getPassword()))
                .orElse(null);

    }


}
