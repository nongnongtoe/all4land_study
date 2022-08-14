package boardexample.myboard.domain.post;

import boardexample.myboard.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(length = 30)
    private String title;

    private String content;

    private LocalDate date;

    private LocalDate updateTable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void updatePost(String title, String content, LocalDate updateTable) {
        this.title = title;
        this.content = content;
        this.updateTable = updateTable;
    }

    @Builder
    public Post(String title, String content, User user,LocalDate date) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.date = date;
    }
}
