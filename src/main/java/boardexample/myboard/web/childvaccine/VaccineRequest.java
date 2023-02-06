package boardexample.myboard.web.childvaccine;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.vachine.ChildVaccine;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VaccineRequest {
    private Long id;

    @NotBlank
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inoculationDate;

    private String memo;

    private String hospital;

    private Child child;

    @Builder
    public VaccineRequest(Long id,String name, LocalDate inoculationDate, String memo, String hospital, Child child) {
        this.id = id;
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
