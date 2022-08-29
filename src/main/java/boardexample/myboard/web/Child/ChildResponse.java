package boardexample.myboard.web.Child;


import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.user.User;
import lombok.Data;

@Data
public class ChildResponse {
    private Long id;
    private String name;

    public ChildResponse(Child entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
