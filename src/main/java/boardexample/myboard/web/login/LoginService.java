package boardexample.myboard.web.login;

import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginService {
    private final UserRepository userRepository;

    public User loginUser(String email, String password){
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }


}
