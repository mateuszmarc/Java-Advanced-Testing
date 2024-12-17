package pl.mateusz.testlifecycle;

public class Task {
    public static Long taskId = 0L;
    private Long id;
    private String title;
    private String description;
    private Status status = Status.INCOMPLETE;

    public Task() {
        taskId++;
        this.id = taskId;
    }

    public Task(String title, String description) {
        taskId++;
        this.id = taskId;
        this.title = title;
        this.description = description;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void completeTask() {
        this.status = Status.COMPLETE;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }
}
