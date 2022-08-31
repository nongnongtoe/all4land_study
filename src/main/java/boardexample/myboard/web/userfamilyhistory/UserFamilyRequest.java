package boardexample.myboard.web.userfamilyhistory;

import boardexample.myboard.domain.familydiseasehistory.MyFamilyHistory;
import boardexample.myboard.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserFamilyRequest {
    private String name;
    private String memo;
    private User user;

    public UserFamilyRequest(String name, String memo, User user) {
        this.name = name;
        this.memo = memo;
        this.user = user;
    }

    public MyFamilyHistory toEntity(){
        return MyFamilyHistory.builder()
                .memo(memo)
                .name(name)
                .build();
    }
}
