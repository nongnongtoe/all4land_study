package boardexample.myboard.domain.allvaccine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AllVaccineRepository extends JpaRepository<AllVaccine, Long> {
    @Query("select a from AllVaccine a where a.startVaccine <= :findOption and a.endVaccine >= :findOption")
    public List<AllVaccine> findBySearchVaccine(@Param("findOption") int birth);
}
