package boardexample.myboard.web.allvaccine.dto;

import lombok.Data;

@Data
public class updateVaccine {
    private int startVaccine;
    private int endVaccine;
    private String title;


    public updateVaccine(int startVaccine, int endVaccine, String title) {
        this.startVaccine = startVaccine;
        this.endVaccine = endVaccine;
        this.title = title;
    }
}
