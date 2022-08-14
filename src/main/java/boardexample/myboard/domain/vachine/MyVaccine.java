package boardexample.myboard.domain.vachine;

import boardexample.myboard.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MyVaccine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_vaccine_id")
    private Long id;

    private String name;

    private Date inoculationDate;

    private String memo;
    private String hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public void updateMyVaccine(String name, Date inoculationDate, String memo, String hospital) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
    }

    @Builder
    public MyVaccine(String name, Date inoculationDate, String memo, String hospital, User user) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
        this.user = user;
    }
}
