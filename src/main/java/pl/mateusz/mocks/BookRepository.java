package pl.mateusz.mocks;

public interface BookRepository {
    Book findBookByTitle(String title);
}
