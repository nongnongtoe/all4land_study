package boardexample.myboard.web.vaccine;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.vachine.ChildVaccine;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class VaccineRequest {

    @NotBlank
    private String name;

    private LocalDate inoculationDate;

    private String memo;

    private String hospital;
    private Child child;

    @Builder
    public VaccineRequest(String name, LocalDate inoculationDate, String memo, String hospital, Child child) {
        this.name = name;
        this.inoculationDate = inoculationDate;
        this.memo = memo;
        this.hospital = hospital;
        this.child = child;
    }

    public ChildVaccine toEntity(){
        return ChildVaccine.builder()
                .name(name)
                .hospital(hospital)
                .inoculationDate(inoculationDate)
                .memo(memo)
                .build();

    }
}
