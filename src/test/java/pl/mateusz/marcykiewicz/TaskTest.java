package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.testlifecycle.Status;
import pl.mateusz.testlifecycle.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TaskTest {

    private Task task = new Task("New task", "Task description");

    @BeforeEach
    public void setup() {
        task.setStatus(Status.INCOMPLETE);
        System.out.println("Before each status: " + task.getStatus());
    }

    @AfterEach
    public void afterEach() {
        task.setStatus(Status.INCOMPLETE);
        System.out.println("After each status: " + task.getStatus());
    }

    @Test
    @DisplayName("Should change status to complete")
    public void givenTask_whenCompleteTask_thenTaskStatusComplete() {

//        when
        task.completeTask();
        System.out.println("Task status in the method " + task.getStatus());

//        then
        assertEquals(Status.COMPLETE, task.getStatus());
    }

    @Test
    @DisplayName("Should change status to complete")
    public void givenTask_whenCompleteTask_thenTaskStatusIsNotIncomplete() {

//        when
        task.completeTask();
        System.out.println("Task status in the method " + task.getStatus());

//        then
        assertNotEquals(Status.INCOMPLETE, task.getStatus());
    }
}
