package pl.mateusz.enums;

public enum Genre {
    ACTION("High-paced movies with intense physical activities"),
    DRAMA("Serious, plot-driven stories with emotional themes"),
    COMEDY("Movies designed to make the audience laugh"),
    SCIENCE_FICTION("Futuristic and imaginative stories involving technology or space"),
    HORROR("Movies that aim to scare and thrill the audience"),
    ROMANCE("Movies focused on relationships and love stories"),
    DOCUMENTARY("Non-fictional movies depicting real events or subjects"),
    FANTASY("Movies involving magical elements or mythical creatures"),
    ANIMATION("Movies created using animated visuals or computer graphics"),
    THRILLER("Suspenseful movies with tension and unexpected twists");

    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
