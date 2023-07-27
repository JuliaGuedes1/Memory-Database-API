package memory.database.api.controller;

import memory.database.api.model.Person;
import memory.database.api.repository.IPersonRepository;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthenticatorController{

    @Autowired
    IPersonRepository iPersonRepository;

    private Response response = new Response();

    Logger logger = LoggerFactory.getLogger(AuthenticatorController.class);

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Person person){
        try {
            List<Person> listPerson = iPersonRepository.findByEmail(person.getEmail());

            if(listPerson.size()==0){
                return ResponseEntity.badRequest().build();
            }
            if(!listPerson.get(0).getPassword().equals(person.getPassword())){
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok().build();

        }catch (Exception e){
            logger.error("Erro ao encontar usuario", e);
            return ResponseEntity.badRequest().build();
        }
    }

}
