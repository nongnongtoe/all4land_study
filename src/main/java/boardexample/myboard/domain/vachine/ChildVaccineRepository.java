package boardexample.myboard.domain.vachine;

import boardexample.myboard.domain.child.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildVaccineRepository extends JpaRepository<ChildVaccine, Long> {
    public List<ChildVaccine> findByChild(Child child);
}
