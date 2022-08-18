package boardexample.myboard.web.allvaccine.dto;


import boardexample.myboard.domain.allvaccine.AllVaccine;
import lombok.Data;

@Data
public class vaccineSaveForm {

    private int startVaccine;
    private int endVaccine;
    private String title;

    public vaccineSaveForm() {
    }

    public vaccineSaveForm(int startVaccine, int endVaccine, String title) {
        this.startVaccine = startVaccine;
        this.endVaccine = endVaccine;
        this.title = title;
    }

    public AllVaccine toEntity(){
        return AllVaccine.builder()
                .startVaccine(startVaccine)
                .endVaccine(endVaccine)
                .title(title)
                .build();
    }
}
