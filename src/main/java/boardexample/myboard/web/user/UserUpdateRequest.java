package boardexample.myboard.web.user;

import lombok.Getter;

@Getter
public class UserUpdateRequest {

    private String password;
    private String phone;

    public UserUpdateRequest(String password, String phone) {
        this.password = password;
        this.phone = phone;
    }
}
