package pl.mateusz.assertJ;

public class Task {

    private static Long lastId = 0L;
    private Long id;
    private String title;
    private String description;
    private Status status;

    public Task(String title, String description) {
        lastId++;
        this.id = lastId;
        this.title = title;
        this.description = description;
        this.status = Status.INCOMPLETE;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
