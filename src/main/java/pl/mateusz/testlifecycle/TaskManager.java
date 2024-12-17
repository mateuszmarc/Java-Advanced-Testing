package pl.mateusz.testlifecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();


    public void addTask(Task task) {

        tasks.add(task);

    }


    public boolean removeTaskById(Long id) {

        if (tasks == null) {
            throw new IllegalArgumentException("Your task list is null");
        }

        return tasks.removeIf(task -> Objects.equals(task.getId(), id));

    }


    public void changeTaskStatus(Long id, Status newStatus) {

        tasks.stream()

                .filter(task -> Objects.equals(task.getId(), id))

                .findFirst()

                .ifPresent(task -> task.setStatus(newStatus));

    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
