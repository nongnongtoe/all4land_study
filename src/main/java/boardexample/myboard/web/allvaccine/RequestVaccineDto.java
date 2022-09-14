package boardexample.myboard.web.allvaccine;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RequestVaccineDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    public RequestVaccineDto(LocalDate birth) {
        this.birth = birth;
    }
}
