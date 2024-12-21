package pl.mateusz.mocks;

import org.junit.jupiter.api.Test;
import pl.mateusz.stubs.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void getPersonById() {

        UserRepository mockUserRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockUserRepository);

        when(mockUserRepository.getPersonById(1L)).thenReturn(new Person("Mateusz", "Marcykiewicz", 12));

        Person person = userService.getPersonById(1L);

        verify(mockUserRepository).getPersonById(1L);

        assertEquals("Mateusz", person.getName());
        assertEquals("Marcykiewicz", person.getLastName());

    }
}