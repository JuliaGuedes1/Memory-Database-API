package memory.database.api.controller;

import memory.database.api.model.Person;
import memory.database.api.repository.IPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    private final IPersonRepository iPersonRepository;

    Logger logger = LoggerFactory.getLogger(PersonController.class);


    public PersonController(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    @GetMapping("person/find-all-person")
    public List<Person> getAllPerson(){

        return iPersonRepository.findAll();

    }

    @GetMapping("person/find/{id}")
    public Person getPersonById(@PathVariable Long id){

        return iPersonRepository.findById(id).get();
    }

    @PostMapping("person/save-person")
    public Person savePerson(@RequestBody Person person){

        return iPersonRepository.save(person);

    }

    @PutMapping("person/update-person/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Long id){

        Person person1 = iPersonRepository.findById(id).get();
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        person1.setAge(person.getAge());
        person1.setEmail(person.getEmail());
        person1.setPassword(person.getPassword());
        return iPersonRepository.save(person1);
    }

    @DeleteMapping("person/delete/{id}")
    public void deletePerson(@PathVariable Long id){

        iPersonRepository.deleteById(id);

    }

}
