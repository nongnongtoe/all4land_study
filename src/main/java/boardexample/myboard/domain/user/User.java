package boardexample.myboard.domain.user;

import boardexample.myboard.domain.child.Child;
import boardexample.myboard.domain.familydiseasehistory.MyFamilyHistory;
import boardexample.myboard.domain.vachine.MyVaccine;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    //이메일로 로그인 처리!
    private String email;

    private String password;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<MyVaccine> myVaccines = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Child> children = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<MyFamilyHistory> myFamilyHistories = new ArrayList<>();

    @Builder
    public User(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
