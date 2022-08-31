package boardexample.myboard.domain.vachine;

import boardexample.myboard.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MyVaccine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_vaccine_id")
    private Long id;

    private String name;

    private LocalDate inoculationDate;

    private String memo;
    private String hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user){
        this.user = user;
        user.getMyVaccines().add(this);
    }


    public void updateMyVaccine(String name, LocalDate inoculationDate, String memo, String hospital) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
    }

    @Builder
    public MyVaccine(String name, LocalDate inoculationDate, String memo, String hospital, User user) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
        this.user = user;
    }
}
