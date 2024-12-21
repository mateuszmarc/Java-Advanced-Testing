package pl.mateusz.stubs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    @Test
    void getAllAdults() {

        PersonService personService = new PersonService(new PersonRepositoryStub());

        List<Person> adults = personService.getAllAdults();

        assertThat(adults).hasSize(2);
    }
    @Test
    void getAllAdultsV2() {

        PersonService personService = new PersonService(new PersonRepositoryStub2());

        List<Person> adults = personService.getAllAdults();

        assertThat(adults).hasSize(1);
    }

    @Test
    void getAllAdultsV3() {

        PersonService personService = new PersonService(new PersonRepositoryStub3());

        List<Person> adults = personService.getAllAdults();

        assertThat(adults).hasSize(0);
    }
}