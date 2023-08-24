package memory.database.api.controller;

import memory.database.api.model.Person;
import memory.database.api.repository.IPersonRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticatorControllerTest {

    AuthenticatorController auth = new AuthenticatorController();

    IPersonRepository iPersonRepository = mock(IPersonRepository.class);

    @BeforeEach
    void before() {
        try {
            Field iPersonRepositoryField = AuthenticatorController.class.getDeclaredField("iPersonRepository");
            iPersonRepositoryField.setAccessible(true);
            iPersonRepositoryField.set(auth, iPersonRepository);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void loginReturns200OK() {

        Person person = new Person();
        List<Person> listPerson = new ArrayList<>();

        person.setFirstName("Fulano");
        person.setEmail("fulano@gmail.com");
        person.setPassword("12345678");

        listPerson.add(person);

        when(iPersonRepository.findByEmail("fulano@gmail.com")).thenReturn(listPerson);
        ResponseEntity<String> response = auth.login(person);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void loginReturnsBadRequestIsEmpty(){

        Person person = new Person();
        List<Person> listPerson = new ArrayList<>();

        when(iPersonRepository.findByEmail("fulano@gmail.com")).thenReturn(listPerson);
        ResponseEntity<String> response = auth.login(person);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void loginReturnsBadRequestNullPointer(){
        Person person = new Person();
        List<Person> listPerson = new ArrayList<>();

        person.setFirstName("Fulano");
        person.setEmail("fulano@gmail.com");
        person.setPassword(null);

        listPerson.add(person);

        when(iPersonRepository.findByEmail("fulano@gmail.com")).thenReturn(listPerson);

        ResponseEntity<String> response = auth.login(person);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}