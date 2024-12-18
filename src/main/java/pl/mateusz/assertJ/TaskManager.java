package pl.mateusz.assertJ;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {

    List<Task> tasks;

    public TaskManager(List<Task> tasks) {
        if (tasks == null) {
            this.tasks = new ArrayList<>();
            return;
        }
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean addTask(String title, String description) {
        if (title == null) {
            throw  new IllegalArgumentException("Title cannot be null");
        }
        return tasks.add(new Task(title, description));
    }

    public boolean removeTaskById(Long id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }

    public boolean updateTask(Task task) {

        Optional<Task> optionalTask = findById(task.getId());

        if (optionalTask.isEmpty()) {
            return false;
        }
        Task foundTask = optionalTask.get();
        foundTask.setTitle(task.getTitle());
        foundTask.setDescription(task.getDescription());
        foundTask.setStatus(task.getStatus());

        return true;
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public List<Task> searchTasksByCreationDate(LocalDate creationDate) {
        return tasks.stream()
                .filter(task -> task.getCreated().equals(creationDate))
                .toList();
    }
}
