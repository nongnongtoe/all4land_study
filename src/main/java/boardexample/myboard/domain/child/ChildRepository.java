package boardexample.myboard.domain.child;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
    public Child findByName(String name);
}
