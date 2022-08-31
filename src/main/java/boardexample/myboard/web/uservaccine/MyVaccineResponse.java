package boardexample.myboard.web.uservaccine;


import boardexample.myboard.domain.user.User;
import boardexample.myboard.domain.vachine.MyVaccine;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MyVaccineResponse {
    private Long id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inoculationDate;

    private String memo;
    private String hospital;


    public MyVaccineResponse(MyVaccine request) {
        this.id = request.getId();
        this.name = request.getName();
        this.inoculationDate = request.getInoculationDate();
        this.memo = request.getMemo();
        this.hospital = request.getHospital();
    }
}
