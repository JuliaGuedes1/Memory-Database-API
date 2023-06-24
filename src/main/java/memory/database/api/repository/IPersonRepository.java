package memory.database.api.repository;

import memory.database.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> {

}
