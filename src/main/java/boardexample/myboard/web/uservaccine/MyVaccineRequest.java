package boardexample.myboard.web.uservaccine;

import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.vachine.MyVaccine;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MyVaccineRequest {
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inoculationDate;

    private String memo;
    private String hospital;
    private User user;

    public MyVaccineRequest(String name, LocalDate inoculationDate, String memo, String hospital, User user) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
        this.user = user;
    }

    public MyVaccine toEntity(){
        return MyVaccine.builder()
                .name(name)
                .inoculationDate(inoculationDate)
                .memo(memo)
                .hospital(hospital)
                .user(user)
                .build();
    }
}
