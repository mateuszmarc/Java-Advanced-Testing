package pl.mateusz.stubs;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryStub implements PersonRepository{
    @Override
    public List<Person> getAllPeople() {
        return new ArrayList<>(List.of(
                new Person("Adam", "AA", 19),
                new Person("Ania", "BB", 80),
                new Person("Ilona", "CC", 16),
                new Person("Damian", "DD", 1)
        ));
    }
}
