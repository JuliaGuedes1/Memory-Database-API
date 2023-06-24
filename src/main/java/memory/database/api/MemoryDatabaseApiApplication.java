package memory.database.api;

import memory.database.api.model.Person;
import memory.database.api.repository.IPersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MemoryDatabaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoryDatabaseApiApplication.class, args);
	}

}
