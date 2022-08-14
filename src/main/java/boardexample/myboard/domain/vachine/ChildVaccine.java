package boardexample.myboard.domain.vachine;

import boardexample.myboard.domain.child.Child;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ChildVaccine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_vaccine_id")
    private Long id;

    private String name;

    private Date inoculationDate;

    private String memo;
    private String hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private Child child;

    public void updateChildVaccine(String name, Date inoculationDate, String memo, String hospital) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
    }

    @Builder
    public ChildVaccine(String name, Date inoculationDate, String memo, String hospital, Child child) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
        this.child = child;
    }
}
