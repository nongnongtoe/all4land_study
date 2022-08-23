package boardexample.myboard.web.Child;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.user.User;
import lombok.Data;

@Data
public class ChildRequest {

    private String name;

    private User user;


    public ChildRequest(String name) {
        this.name = name;
    }

    public Child toEntity(){
        return Child.builder()
                .name(name)
                .user(user)
                .build();
    }
}
