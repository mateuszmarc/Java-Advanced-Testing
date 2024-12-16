package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mateusz.assertions.Book;
import pl.mateusz.assertions.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setup() {
        library = new Library();
        library.setBooks(
                new ArrayList<>(List.of(
                        new Book("Book Title 1", "Author 1", 2001),
                        new Book("Book Title 2", "Author 2", 2002),
                        new Book("Book Title 3", "Author 3", 2003),
                        new Book("Book Title 4", "Author 4", 2004),
                        new Book("Book Title 5", "Author 5", 2005),
                        new Book("Book Title 6", "Author 6", 2006),
                        new Book("Book Title 7", "Author 7", 2007),
                        new Book("Book Title 8", "Author 8", 2008),
                        new Book("Book Title 9", "Author 9", 2009),
                        new Book("Book Title 10", "Author 10", 2010)
                ))
        );
    }

    @Test
    public void givenEmptyLibrary_whenSearchBookByTitle_thenResultIsEmpty() {
//        given
        library.getBooks().clear();
        String title = "Book Title 1";

//        when
        Optional<Book> optionalBook = library.findBookByTitle(title);

//        then
        assertTrue(optionalBook.isEmpty());
    }

    @Test
    public void givenFullLibrary_whenSearchBookByTitle_thenResultIsPresent() {
//        given
        String title = "Book Title 1";

//        when
        Optional<Book> optionalBook = library.findBookByTitle(title);

//        then
        assertTrue(optionalBook.isPresent());
    }

    @Test
    public void givenFullLibrary_whenSearchBookByTitle_thenResultIsNotPresent() {
//        given
        String title = "Book Title 17";

//        when
        Optional<Book> optionalBook = library.findBookByTitle(title);

//        then
        assertTrue(optionalBook.isEmpty());
    }

    @Test
    public void givenFullLibrary_whenSearchBookByEmptyBookTitle_thenResultIsNotPresent() {
//        given
        String title = "";

//        when
        Optional<Book> optionalBook = library.findBookByTitle(title);

//        then
        assertTrue(optionalBook.isEmpty());
    }

    @Test
    public void givenFullLibrary_whenSearchBookByBlankBookTitle_thenResultIsNotPresent() {
//        given
        String title = "   ";

//        when
        Optional<Book> optionalBook = library.findBookByTitle(title);

//        then
        assertTrue(optionalBook.isEmpty());
    }

    @Test
    public void givenFullLibrary_whenSearchBookNullTitle_thenResultIsNotPresent() {
//        given
        String title = null;

//        when
        Optional<Book> optionalBook = library.findBookByTitle(title);

//        then
        assertTrue(optionalBook.isEmpty());
    }
}
