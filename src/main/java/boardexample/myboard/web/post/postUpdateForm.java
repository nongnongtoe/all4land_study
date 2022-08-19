package boardexample.myboard.web.post;

import boardexample.myboard.domain.post.Post;
import lombok.Data;

import java.time.LocalDate;

@Data
public class postUpdateForm {
    private Long id;

    private String title;
    private String content;

    private LocalDate updateTable;

    public postUpdateForm(Long id, String title, String content, LocalDate updateTable) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.updateTable = updateTable;
    }

}
