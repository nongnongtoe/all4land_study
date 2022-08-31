package boardexample.myboard.web.post;

import boardexample.myboard.domain.post.Post;
import boardexample.myboard.domain.user.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PostResponseDto {
    private Long id;

    private String title;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateTable;

    private String email;

    public PostResponseDto(Long id, String title, String content, LocalDate date, LocalDate updateTable, String email) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.updateTable = updateTable;
        this.email = email;
    }

}
