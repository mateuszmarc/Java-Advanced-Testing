package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mateusz.testlifecycle.Task;
import pl.mateusz.testlifecycle.TaskManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setup() {
        this.taskManager = new TaskManager();
        Task.taskId = 0L;
        taskManager.setTasks(new ArrayList<>(List.of(
                new Task(),
                new Task(),
                new Task(),
                new Task(),
                new Task(),
                new Task(),
                new Task(),
                new Task()
        )));
    }

    @Test
    public void givenTaskManager_whenRemoveTask_thenTaskIsRemoved() {

//        given
        int taskLengthBeforeRemoval = taskManager.getTasks().size();
        int expectedLengthAfterRemoval = taskLengthBeforeRemoval - 1;

//      when
        boolean isRemoved = taskManager.removeTaskById(1L);

//        then
        assertEquals(expectedLengthAfterRemoval, taskManager.getTasks().size());
        assertTrue(isRemoved);
    }

    @Test
    public void givenTaskManager_whenRemoveTaskThatIsNotPresent_thenTaskIsNotRemoved() {

//        given
        int taskLengthBeforeRemoval = taskManager.getTasks().size();

//      when
        boolean isRemoved = taskManager.removeTaskById(11L);
        System.out.println(taskManager.getTasks());

//        then
        assertEquals(taskLengthBeforeRemoval, taskManager.getTasks().size());
        assertFalse(isRemoved);

    }

    @Test
    public void givenTaskManagerEmptyTaskList_whenRemoveTask_thenTaskIsNotRemoved() {

//        given
        taskManager.getTasks().clear();
        int taskLengthBeforeRemoval = taskManager.getTasks().size();

//      when
        boolean isRemoved = taskManager.removeTaskById(11L);
        System.out.println(taskManager.getTasks());

//        then
        assertEquals(taskLengthBeforeRemoval, taskManager.getTasks().size());
        assertFalse(isRemoved);
    }

    @Test
    public void givenTaskManagerNullTaskList_whenRemoveTask_thenTaskIsNotRemoved() {

//        given
        taskManager.setTasks(null);

//        then
        assertThrows(IllegalArgumentException.class, () -> taskManager.removeTaskById(1L));
    }

    @Test
    public void givenTaskManagerTaskList_whenRemoveTaskWithNullId_thenTaskIsNotRemoved() {

//        given
        int taskLengthBeforeRemoval = taskManager.getTasks().size();

//      when
       boolean isRemoved = taskManager.removeTaskById(null);
        System.out.println(taskManager.getTasks());

//        then
        assertEquals(taskLengthBeforeRemoval, taskManager.getTasks().size());
        assertFalse(isRemoved);
    }


}
