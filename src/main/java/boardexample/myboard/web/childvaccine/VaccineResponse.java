package boardexample.myboard.web.childvaccine;

import boardexample.myboard.domain.vachine.ChildVaccine;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VaccineResponse {
    private Long id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inoculationDate;

    private String memo;

    private String hospital;

    public VaccineResponse(ChildVaccine vaccine) {
        this.id = vaccine.getId();
        this.name = vaccine.getName();
        this.inoculationDate = vaccine.getInoculationDate();
        this.memo = vaccine.getMemo();
        this.hospital = vaccine.getHospital();
    }
}
