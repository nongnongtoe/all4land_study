package boardexample.myboard.domain.vachine;

import boardexample.myboard.domain.child.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildVaccineRepository extends JpaRepository<ChildVaccine, Long> {
}
