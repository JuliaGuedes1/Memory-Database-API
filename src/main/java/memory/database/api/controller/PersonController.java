package memory.database.api.controller;

import memory.database.api.model.Person;
import memory.database.api.model.PersonDTO;
import memory.database.api.repository.IPersonRepository;
import memory.database.api.util.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private final IPersonRepository iPersonRepository;

    private Interceptor interceptor;

    Logger logger = LoggerFactory.getLogger(PersonController.class);


    public PersonController(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
        this.interceptor = new Interceptor();
    }

    @GetMapping("person/find-all-person")
    public ResponseEntity<List<PersonDTO>> getAllPerson(@RequestHeader("Authorization") String token){

        if(!interceptor.validate(token)){
            return ResponseEntity.badRequest().build();
        }

        List<Person> personList = iPersonRepository.findAll();
        List<PersonDTO> personWithoutString = new ArrayList<>();

        PersonDTO personDTO = new PersonDTO();
        for(Person person: personList){
            personDTO.setId(person.getId());
            personDTO.setAge(person.getAge());
            personDTO.setEmail(person.getEmail());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
            personWithoutString.add(personDTO);
        }

        return new ResponseEntity<>(personWithoutString, HttpStatus.OK);

    }

    @GetMapping("person/find/{id}")
    public Person getPersonById(@PathVariable Long id){

        return iPersonRepository.findById(id).get();

        /*PersonDTO personDTO = new PersonDTO();
        for(Person personi: person){
            personDTO.setId(personi.getId());
            personDTO.setAge(personi.getAge());
            personDTO.setEmail(personi.getEmail());
            personDTO.setFirstName(personi.getFirstName());
            personDTO.setLastName(personi.getLastName());
        }*/
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

    @GetMapping("person/find-all")
    public ResponseEntity<List<Person>> getAll(@RequestHeader("Authorization") String token){

        if(!interceptor.validate(token)){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(iPersonRepository.findAll(), HttpStatus.OK);

    }

}
