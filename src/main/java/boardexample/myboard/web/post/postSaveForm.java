package boardexample.myboard.web.post;

import boardexample.myboard.domain.post.Post;
import boardexample.myboard.domain.user.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class postSaveForm {
    private String title;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private User user;

    public void setUser(User user){
        this.user = user;
    }


    @Builder
    public postSaveForm(String title, String content, LocalDate date, User user) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .date(date)
                .user(user)
                .build();
    }
}
