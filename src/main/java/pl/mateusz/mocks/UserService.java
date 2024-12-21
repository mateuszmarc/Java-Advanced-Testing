package pl.mateusz.mocks;

import pl.mateusz.stubs.Person;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Person getPersonById(Long id) {
        return userRepository.getPersonById(id);
    }
}
