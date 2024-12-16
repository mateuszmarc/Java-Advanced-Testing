package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mateusz.assertions.Book;
import pl.mateusz.assertions.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void givenFullLibrary_whenSearchByPresentAndAvailableBook_thenBookIsPresent() {
        //        given
        String title = "Book Title 1";

        String author = "Author 1";

        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isPresent());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isPresent());

        //        when
        Book book = library.findBookByTitleAndAuthor(title, author);

        //        then
        assertNotNull(book);
    }

    @Test
    public void givenFullLibrary_whenSearchByUnavailableTitleAndCorrectAuthor_thenBookIsNull() {
        //        given
        String title = "Book Title 144";

        String author = "Author 1";



        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isPresent());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
    }

    @Test
    public void givenFullLibrary_whenSearchByTitleAndIncorrectAuthor_thenBookIsNull() {
        //        given
        String title = "Book Title 1";

        String author = "Author 15432";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isPresent());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByIncorrectTitleAndIncorrectAuthor_thenBookIsNull() {
        //        given
        String title = "Book Title 1sass";

        String author = "Author 15432";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }


    @Test
    public void givenFullLibrary_whenSearchByEmptyTitleAndIncorrectAuthor_thenBookIsNull() {
        //        given
        String title = "";

        String author = "Author 15432";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByEmptyTitleAndCorrectAuthor_thenBookIsNull() {
        //        given
        String title = "";

        String author = "Author 1";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isPresent());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByCorrectTitleAndEmptyAuthor_thenBookIsNull() {
        //        given
        String title = "Book Title 1";

        String author = "";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isPresent());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByCorrectTitleAndBlankAuthor_thenBookIsNull() {
        //        given
        String title = "Book Title 1";

        String author = "   ";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isPresent());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByCorrectTitleAndCorrectAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = "Book Title 1";

        String author = "Author 1";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByEmptyTitleAndEmptyAuthor_thenBookIsNull() {
        //        given
        String title = "";

        String author = "";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByNullTitleAndNullAuthor_thenBookIsNull() {
        //        given
        String title = null;

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByNullTitleAndCorrectAuthor_thenBookIsNull() {
        //        given
        String title = null;

        String author = "Author 1";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isPresent());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByCorrectTitleAndNullAuthor_thenBookIsNull() {
        //        given
        String title = "Book Title 1";

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isPresent());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByIncorrectTitleAndNullAuthor_thenBookIsNull() {
        //        given
        String title = "Book Title 1sdfaf";

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibrary_whenSearchByNullTitleAndIncorrectAuthor_thenBookIsNull() {
        //        given
        String title = null;

        String author = "Author 1";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isPresent());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByNullTitleAndNullAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = null;

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByCorrectTitleAndNullAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = "Book Title 1";

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByIncorrectTitleAndNullAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = "Book Title 1sfaf";

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByEmptyTitleAndNullAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = "";

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByBlankTitleAndNullAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = "  ";

        String author = null;

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByNullTitleAndAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = null;

        String author = "Author 1";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenEmptyLibrary_whenSearchByNullTitleEmptyAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = null;

        String author = "";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }


    @Test
    public void givenEmptyLibrary_whenSearchByNullTitleBlankAuthor_thenBookIsNull() {
        //        given
        library.getBooks().clear();
        String title = null;

        String author = "   ";

        //        then
        Optional<Book> foundByTitle = library.findBookByTitle(title);
        assertTrue(foundByTitle.isEmpty());

        Optional<Book> foundByAuthor = library.getBooks().stream().filter(book -> book.getAuthor().equals(author)).findFirst();
        assertTrue(foundByAuthor.isEmpty());

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

    @Test
    public void givenFullLibraryOnlyWithAvailableBooks_whenBorrowBook_thenBookNotNull() {
//        given
        String title = "Book Title 1";
        String author = "Author 1";

//        when
        Book foundBook = library.findBookByTitleAndAuthor(title, author);
        assertTrue(foundBook.isAvailable());

        Book book = library.borrowBook(title, author);

//        then
        assertNotNull(book);
        assertSame(foundBook, book);
        assertFalse(book.isAvailable());

    }

    @Test
    public void givenFullLibraryOnlyWithUnavailableBooks_whenBorrowBook_thenBookIsNull() {
//        given
        library.getBooks().forEach(book -> book.setAvailable(false));
        String title = "Book Title 1";
        String author = "Author 1";

//        when
        Book foundBook = library.findBookByTitleAndAuthor(title, author);
        assertFalse(foundBook.isAvailable());

        Book book = library.borrowBook(title, author);

//        then
        assertNull(book);
    }

    @Test
    public void givenFullLibraryOnlyWithAvailableBooks_whenBorrowBookWithWrongTitle_ThrowRuntimeException() {
//        given

        String title = "Book Title 1sss";
        String author = "Author 1";

//        then
        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
        assertThrows(RuntimeException.class, () -> library.borrowBook(title, author));

    }

    @Test
    public void givenFullLibraryOnlyWithAvailableBooks_whenBorrowBookWithWrongAuthor_ThrowRuntimeException() {
//        given

        String title = "Book Title 1";
        String author = "Author 1dafd";

//        then
        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
        assertThrows(RuntimeException.class, () -> library.borrowBook(title, author));

    }

    @Test
    public void givenFullLibraryOnlyWithAvailableBooks_whenBorrowBookWithNullTitle_ThrowRuntimeException() {
//        given

        String title = null;
        String author = "Author 1dafd";

//        then
        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
        assertThrows(RuntimeException.class, () -> library.borrowBook(title, author));

    }

    @Test
    public void givenFullLibraryOnlyWithAvailableBooks_whenBorrowBookWithNullAuthor_ThrowRuntimeException() {
//        given

        String title = "Book Title 1";
        String author = null;

//        then

        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
        assertThrows(RuntimeException.class, () -> library.borrowBook(title, author));

    }

    @Test
    public void givenFullLibraryOnlyWithUnavailableBooks_whenBorrowBookWithNullAuthor_ThrowRuntimeException() {
//        given
        library.getBooks().forEach(book -> book.setAvailable(false));
        String title = "Book Title 1";
        String author = null;


//        then
        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
        assertThrows(RuntimeException.class, () -> library.borrowBook(title, author));

    }

    @Test
    public void givenFullLibraryOnlyWithUnavailableBooks_whenBorrowBookWithNullTitle_ThrowRuntimeException() {
//        given
        library.getBooks().forEach(book -> book.setAvailable(false));
        String title = null;
        String author = "Author 1";

//        then
        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
        assertThrows(RuntimeException.class, () -> library.borrowBook(title, author));
    }

    @Test
    public void givenEmptyLibrary_whenBorrowBook_thenThrowRuntimeException() {
//        given
        library.getBooks().clear();
        String title = "Book Title 1";
        String author = "Author 1";


//        then
        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));
        assertThrows(RuntimeException.class, () -> library.findBookByTitleAndAuthor(title, author));

    }

}
