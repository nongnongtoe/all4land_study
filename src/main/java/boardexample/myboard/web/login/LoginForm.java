package boardexample.myboard.web.login;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @Email
    public String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    public String password;
}
