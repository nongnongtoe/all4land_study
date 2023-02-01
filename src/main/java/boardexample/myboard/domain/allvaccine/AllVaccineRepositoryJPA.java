package boardexample.myboard.domain.allvaccine;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class AllVaccineRepositoryJPA {

    private final EntityManager em;

    public List<AllVaccine> findVaccineList(int findBirth){
        return em.createQuery("select a from AllVaccine a " +
                "where a.startVaccine <= :findBirth and a.endVaccine >= :findBirth")
                .setParameter("findBirth", findBirth)
                .getResultList();
    }
}
