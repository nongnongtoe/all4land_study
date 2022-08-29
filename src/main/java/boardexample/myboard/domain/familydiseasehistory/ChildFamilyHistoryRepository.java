package boardexample.myboard.domain.familydiseasehistory;

import boardexample.myboard.domain.child.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildFamilyHistoryRepository extends JpaRepository<ChildFamilyHistory, Long> {
    public List<ChildFamilyHistory> findByChild(Child child);
}
