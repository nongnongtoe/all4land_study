package boardexample.myboard.domain.vachine;

import boardexample.myboard.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyVaccineRepository extends JpaRepository<MyVaccine, Long> {
    public List<MyVaccine> findByUser(User user);
}
