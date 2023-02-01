package boardexample.myboard.web.user;

import boardexample.myboard.domain.user.Role;
import boardexample.myboard.domain.user.User;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserSaveForm {

    @Email @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private String phone;

    @NotNull
    private Boolean adminCheck;

    public UserSaveForm() {
    }

    public UserSaveForm(String email, String password, String phone, Boolean adminCheck) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.adminCheck = adminCheck;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .phone(phone)
                .adminCheck(adminCheck)
                .build();
    }


}
