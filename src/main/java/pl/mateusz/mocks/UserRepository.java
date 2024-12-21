package pl.mateusz.mocks;

import pl.mateusz.stubs.Person;

public interface UserRepository {
    Person getPersonById(Long id);
}
