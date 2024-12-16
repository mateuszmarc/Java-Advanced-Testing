package pl.mateusz.assertions;

public class Book {
    private static Long lastId = 0L;
    private Long id;
    private String title;
    private String author;
    private int yearOfPublication;

    public Book(String title, String author, Integer yearOfPublication) {
        lastId++;
        this.id = lastId;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return title;
    }
}
