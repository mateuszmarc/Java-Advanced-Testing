package pl.mateusz.assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Optional<Book> findBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst();
    }
}
