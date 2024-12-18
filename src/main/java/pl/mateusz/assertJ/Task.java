package pl.mateusz.assertJ;

import java.time.LocalDate;

public class Task {

    private static Long lastId = 0L;
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate created;

    public Task(String title, String description) {
        lastId++;
        this.id = lastId;
        this.title = title;
        this.description = description;
        this.status = Status.INCOMPLETE;
        this.created = LocalDate.now();
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

    public LocalDate getCreated() {
        return created;
    }
}
