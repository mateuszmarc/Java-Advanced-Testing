package pl.mateusz.mocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Test
    void findByTitle() {

        BookRepository bookRepositoryMock = mock(BookRepository.class);
        when(bookRepositoryMock.findBookByTitle("Harry Potter")).thenReturn(new Book(1L,"Harry Potter", "J.K Rowling"));

        BookService bookService = new BookService(bookRepositoryMock);

        Book found = bookService.findByTitle("Harry Potter");

        assertEquals("Harry Potter", found.getTitle());
    }
}