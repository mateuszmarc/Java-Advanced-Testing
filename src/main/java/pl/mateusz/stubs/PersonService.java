package pl.mateusz.stubs;

import java.util.List;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllAdults() {
        return personRepository.getAllPeople().stream().filter(person -> person.getAge() >= 18).toList();
    }
}
