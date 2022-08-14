package boardexample.myboard.domain.allvaccine;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class AllVaccine {
    @Id @GeneratedValue
    @Column(name = "allvaccine_id")
    private Long id;

    private int startVaccine;
    private int endVaccine;

    private String title;

    public void updateAllVaccine(int startVaccine, int endVaccine, String title) {
        this.startVaccine = startVaccine;
        this.endVaccine = endVaccine;
        this.title = title;
    }


    @Builder
    public AllVaccine(int startVaccine, int endVaccine, String title) {
        this.startVaccine = startVaccine;
        this.endVaccine = endVaccine;
        this.title = title;
    }
}
