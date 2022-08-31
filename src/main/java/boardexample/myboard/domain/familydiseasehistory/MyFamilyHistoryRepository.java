package boardexample.myboard.domain.familydiseasehistory;

import boardexample.myboard.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyFamilyHistoryRepository extends JpaRepository<MyFamilyHistory, Long> {
    public List<MyFamilyHistory> findByUser(User user);
}
