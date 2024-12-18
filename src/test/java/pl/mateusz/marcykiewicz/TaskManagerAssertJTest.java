package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.assertJ.Status;
import pl.mateusz.assertJ.Task;
import pl.mateusz.assertJ.TaskManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


public class TaskManagerAssertJTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setup() {
        this.taskManager = new TaskManager(
                new ArrayList<Task>(List.of(
                        new Task("Task 1", "Description 1"),
                        new Task("Task 2", "Description 2"),
                        new Task("Task 3", "Description 3"),
                        new Task("Task 4", "Description 4"),
                        new Task("Task 5", "Description 5")
                ))
        );
    }

    @Test
    @DisplayName("Test addTask method")
    public void givenTaskManager_whenAddingTask_thenTaskAdded() {

//        given
        String taskTitle = "Task title";
        String taskDescription = "Task description";

//        when
        boolean isAdded = taskManager.addTask(taskTitle, taskDescription);

//        then
        assertThat(isAdded).isTrue();
        assertThat(taskManager.getTasks()).hasSize(6);
    }

    @Test
    @DisplayName("Test removeTaskById method for empty task list")
    public void givenEmptyTaskManagerList_whenRemoveById_thenShouldBeFalse() {

//        given
        taskManager.getTasks().clear();
        Long id = 1L;

//        when
        boolean isRemoved = taskManager.removeTaskById(id);

//        then
        assertThat(isRemoved).isFalse();
    }

    @Test
    @DisplayName("Test removeTaskById method id not in the task list")
    public void givenTaskManagerList_whenRemoveById_thenShouldBeFalse() {

//        given

        Long id = 111L;

//        when
        boolean isRemoved = taskManager.removeTaskById(id);

//        then
        assertAll(
                () -> assertThat(isRemoved).isFalse(),
                () -> assertThat(taskManager.getTasks()).hasSize(5)
        );

    }

    @Test
    @DisplayName("Test removeTaskById method when id is equal to null")
    public void givenTaskManagerList_whenRemoveByIdWhichIsNull_thenShouldBeFalse() {

//        given
        Long id = null;

//        when
        boolean isRemoved = taskManager.removeTaskById(id);

//        then
        assertAll(
                () -> assertThat(isRemoved).isFalse(),
                () -> assertThat(taskManager.getTasks()).hasSize(5)
        );

    }

    @Test
    @DisplayName("Test removeTaskById method")
    public void givenTaskManagerList_whenRemoveByIdWhich_thenShouldBeTrue() {

//        given
        Long id = taskManager.getTasks().get(1).getId();

//        when
        boolean isRemoved = taskManager.removeTaskById(id);

//        then
        assertAll(
                () -> assertThat(isRemoved).isTrue(),
                () -> assertThat(taskManager.getTasks()).hasSize(4)
        );
    }

    @Test
    @DisplayName("Test findById method for id in the list")
    public void givenTaskManager_whenFindTaskById_thenReturnTask() {
        //        given
        Long id = taskManager.getTasks().get(1).getId();

//        when
        Optional<Task> optionalTask = taskManager.findById(id);

//        then

        assertThat(optionalTask).isPresent();
    }

    @Test
    @DisplayName("Test findById method for task id not in the list")
    public void givenTaskManager_whenFindTaskById_thenReturnEmptyTask() {
        //        given
        Long id = 111L;

//        when
        Optional<Task> optionalTask = taskManager.findById(id);

//        then

        assertThat(optionalTask).isEmpty();
    }

    @Test
    @DisplayName("Test findById method when empty taks manager list")
    public void givenEmptyTaskManager_whenFindTaskById_thenReturnEmptyTask() {
        //        given
        taskManager.getTasks().clear();
        Long id = 111L;

//        when
        Optional<Task> optionalTask = taskManager.findById(id);

//        then

        assertThat(optionalTask).isEmpty();
    }

    @Test
    @DisplayName("Test findById method whenid is null")
    public void givenTaskManager_whenFindTaskByNullId_thenReturnEmptyTask() {
        //        given
        Long id = null;

//        when
        Optional<Task> optionalTask = taskManager.findById(id);

//        then

        assertThat(optionalTask).isEmpty();
    }

    @Test
    @DisplayName("Test update task for task in the task list")
    public void givenTaskManager_whenUpdatePresentTask_ThenTaskUpdated() {

//        given
        Task task = taskManager.getTasks().get(1);
        task.setStatus(Status.COMPLETED);
        task.setDescription("Updated description");
        task.setTitle("Updated title");

//        then
        boolean isUpdated = taskManager.updateTask(task);

//        then
        assertAll(
                () -> assertThat(task).isEqualTo(taskManager.getTasks().get(1)),
                () -> assertThat(task.getTitle()).isEqualTo(taskManager.getTasks().get(1).getTitle()),
                () -> assertThat(task.getDescription()).isEqualTo(taskManager.getTasks().get(1).getDescription()),
                () -> assertThat(task.getStatus()).isEqualTo(taskManager.getTasks().get(1).getStatus()),
                () -> assertThat(isUpdated).isTrue()
        );
    }

    @Test
    @DisplayName("Test update task for task not present in the task list")
    public void givenTaskManager_whenUpdateTask_ThenTaskNotUpdated() {

//        given
        Task task = new Task("Updated task", "Updated description");

//        then
        boolean isUpdated = taskManager.updateTask(task);

//        then
        assertThat(isUpdated).isFalse();
    }

    @Test
    @DisplayName("Test update task for task not present in the task list")
    public void givenEmptyTaskManagerList_whenUpdateTask_ThenTaskNotUpdated() {

//        given
        taskManager.getTasks().clear();
        Task task = new Task("Updated task", "Updated description");

//        then
        boolean isUpdated = taskManager.updateTask(task);

//        then
        assertThat(isUpdated).isFalse();
    }

    @Test
    @DisplayName("Test addTask when title is null should throw IllegalArgumentException")
    public void givenTaskManager_whenAddTaskTitleIsNull_thenThrowIllegalArgumentException() {
//        given
        String title = null;
        String description = "Description";

//        when &then
        assertThatThrownBy(() -> taskManager.addTask(title, description))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Title cannot be null");
    }

    @Test
    @DisplayName("Test searchTasks")
    public void givenTaskManager_whenSearchTask_thenReturnTaskList() {
//        given
        LocalDate created = taskManager.getTasks().get(1).getCreated();

//        when
        List<Task> tasks = taskManager.searchTasksByCreationDate(created);

//        then
        assertThat(tasks).isNotEmpty();
    }

    @Test
    @DisplayName("Test searchTasks")
    public void givenTaskManager_whenSearchTaskForWrongCreationDate_thenReturnEmptyTaskList() {
//        given
        LocalDate created = LocalDate.of(2033, 1, 1);

//        when
        List<Task> tasks = taskManager.searchTasksByCreationDate(created);

//        then
        assertThat(tasks).isEmpty();
    }

    @Test
    @DisplayName("Test searchTasks")
    public void givenTaskManager_whenSearchTaskForNullCreationDate_thenReturnEmptyTaskList() {
//        given
        LocalDate created = null;

//        when
        List<Task> tasks = taskManager.searchTasksByCreationDate(created);

//        then
        assertThat(tasks).isEmpty();
    }
}
