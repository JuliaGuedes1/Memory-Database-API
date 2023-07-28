package memory.database.api.repository;

import memory.database.api.model.Authenticator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAuthRepository extends JpaRepository<Authenticator, Long> {

    List<Authenticator> findByToken(String token);

}
