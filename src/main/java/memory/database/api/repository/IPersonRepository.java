package memory.database.api.repository;

import memory.database.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IPersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByEmail(String email);

}
