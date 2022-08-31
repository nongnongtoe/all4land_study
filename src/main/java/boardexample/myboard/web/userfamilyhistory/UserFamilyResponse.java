package boardexample.myboard.web.userfamilyhistory;


import boardexample.myboard.domain.familydiseasehistory.MyFamilyHistory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFamilyResponse {
    private Long id;
    private String name;
    private String memo;


    public UserFamilyResponse(MyFamilyHistory familyHistory) {
        this.id = familyHistory.getId();
        this.name = familyHistory.getName();
        this.memo = familyHistory.getMemo();
    }
}
