package memory.database.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person = new Person("fulano", "fulano@gmail.com", "werfe3526&");

    @Test
    void getId() {

        person.setId(1L);
        assertEquals(1L,person.getId());


    }

    @Test
    void getFirstName() {
        person.setFirstName("Fulano");
        assertEquals("Fulano", person.getFirstName());
    }


    @Test
    void getLastName() {
        person.setLastName("da Silva");
        assertEquals("da Silva", person.getLastName());
    }

    @Test
    void getAge() {
        person.setAge(32);
        assertEquals(32, person.getAge());
    }


    @Test
    void getEmail() {
        person.setEmail("fulano@gmail.com");
        assertEquals("fulano@gmail.com", person.getEmail());
    }


    @Test
    void getPassword() {
        person.setPassword("fhj85@fcas");
        assertEquals("fhj85@fcas", person.getPassword());
    }

}