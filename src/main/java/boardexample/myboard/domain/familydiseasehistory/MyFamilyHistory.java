package boardexample.myboard.domain.familydiseasehistory;

import boardexample.myboard.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MyFamilyHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_family_history_id")
    private Long id;

    private String name;

    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void updateMyFamilyHistory(String name, String memo) {
        this.name = name;
        this.memo = memo;
    }

    @Builder
    public MyFamilyHistory(String name, String memo, User user) {
        this.name = name;
        this.memo = memo;
        this.user = user;
    }
}
