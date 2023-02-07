package boardexample.myboard.web.Child;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
public class ChildRequest {


    private String name;

    private User user;

    private MultipartFile file;

    private List<MultipartFile> files;

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
