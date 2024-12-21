package pl.mateusz.mocks;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }
}
