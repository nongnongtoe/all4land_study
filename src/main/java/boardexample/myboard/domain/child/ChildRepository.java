package boardexample.myboard.domain.child;

import boardexample.myboard.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    public Child findByName(String name);

    public List<Child> findByUser(User user);
}
