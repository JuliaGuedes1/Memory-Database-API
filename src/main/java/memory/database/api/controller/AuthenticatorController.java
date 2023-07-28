package memory.database.api.controller;

import memory.database.api.model.Authenticator;
import memory.database.api.model.Person;
import memory.database.api.repository.IAuthRepository;
import memory.database.api.repository.IPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@RestController
public class AuthenticatorController{

    @Autowired
    IPersonRepository iPersonRepository;

    @Autowired
    IAuthRepository iAuthRepository;

    Logger logger = LoggerFactory.getLogger(AuthenticatorController.class);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Person person){
        try {
            List<Person> listPerson = iPersonRepository.findByEmail(person.getEmail());
            Authenticator auth = new Authenticator();


            if(listPerson.isEmpty()){
                return ResponseEntity.badRequest().build();
            }
            if(!listPerson.get(0).getPassword().equals(person.getPassword())){
                return ResponseEntity.badRequest().build();
            }


            auth.setToken(generateRandomString());
            auth.setExpiration(2L);

            return new ResponseEntity<>(iAuthRepository.save(auth).getToken(), HttpStatus.OK);

        }catch (Exception e){
            logger.error("Erro ao encontar usuario", e);
            return ResponseEntity.badRequest().build();
        }
    }

    public String generateRandomString() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);

        return(generatedString);
    }

}
