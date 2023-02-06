package boardexample.myboard.web.childfamilyhistory;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.familydiseasehistory.ChildFamilyHistory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChildFamilyHistoryRequest {
    private Long id;
    private String name;
    private String memo;
    private Child child;


    public ChildFamilyHistoryRequest(String name, String memo, Child child) {
        this.id = id;
        this.name = name;
        this.memo = memo;
        this.child = child;
    }

    public ChildFamilyHistory toEntity(){
        return ChildFamilyHistory.builder()
                .name(name)
                .memo(memo)
                .child(child)
                .build();
    }
}
