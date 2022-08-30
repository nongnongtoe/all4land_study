package boardexample.myboard.web.allvaccine;


import boardexample.myboard.domain.allvaccine.AllVaccine;
import lombok.Data;

@Data
public class allVaccineResponse {
    private Long id;
    private int startVaccine;
    private int endVaccine;
    private String title;

    public allVaccineResponse(AllVaccine request) {
        this.id = request.getId();
        this.startVaccine = request.getStartVaccine();
        this.endVaccine = request.getEndVaccine();
        this.title = request.getTitle();
    }
}
