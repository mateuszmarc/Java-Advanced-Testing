package pl.mateusz.enums;

public class Movie {
    private String title;
    private Genre genre;
    private String director;

    public Movie(String title, Genre genre, String director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
    }


    public void displayDetails() {

        System.out.println("Title: " + title);

        System.out.println("Genre: " + genre);

        System.out.println("Director: " + director);

    }
}
