package boardexample.myboard.domain.vachine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyVaccineRepository extends JpaRepository<MyVaccine, Long> {
}
