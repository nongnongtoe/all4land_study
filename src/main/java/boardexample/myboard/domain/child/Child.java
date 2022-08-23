package boardexample.myboard.domain.child;

import boardexample.myboard.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Child {

    @Id @GeneratedValue
    @Column(name = "child_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void updateChild(String name){
        this.name = name;
    }

    public void setUser(User user){
        this.user =user;
        user.getChildren().add(this);
    }

    @Builder
    public Child(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
