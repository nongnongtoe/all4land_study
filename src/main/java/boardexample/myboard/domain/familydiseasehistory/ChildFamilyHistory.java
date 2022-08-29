package boardexample.myboard.domain.familydiseasehistory;

import boardexample.myboard.domain.child.Child;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ChildFamilyHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_family_history_id")
    private Long id;

    private String name;

    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private Child child;

    public void setChild(Child child){
        this.child = child;
        child.getHistoryList().add(this);
    }

    public void updateChildFamilyHistory(String name, String memo, Child child) {
        this.name = name;
        this.memo = memo;
        this.child = child;
    }

    @Builder
    public ChildFamilyHistory(String name, String memo, Child child) {
        this.name = name;
        this.memo = memo;
        this.child = child;
    }
}
