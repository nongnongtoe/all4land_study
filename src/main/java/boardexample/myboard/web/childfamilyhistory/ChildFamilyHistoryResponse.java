package boardexample.myboard.web.childfamilyhistory;

import boardexample.myboard.domain.familydiseasehistory.ChildFamilyHistory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChildFamilyHistoryResponse {
    private Long id;
    private String name;
    private String memo;

    public ChildFamilyHistoryResponse(ChildFamilyHistory request) {
        this.id = request.getId();
        this.name = request.getName();
        this.memo = request.getMemo();
    }
}
