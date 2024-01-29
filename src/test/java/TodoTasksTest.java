import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoTasksTest {

    @Test
    void saveTodoItem() {
        // Arrange
        TodoTasks todoTasks = new TodoTasks();
        TodoItem mockTodoItem = mock(TodoItem.class);

        // Act
        todoTasks.save(mockTodoItem);

        // Assert
        List<TodoItem> todoList = todoTasks.getTodoList();
        assertEquals(1, todoList.size());
        assertEquals(mockTodoItem, todoList.get(0));
        assertEquals(0, mockTodoItem.getId()); // Assuming you start with id 0
    }

    @Test
    void updateTodoItem() {
        // Arrange
        TodoTasks todoTasks = new TodoTasks();
        TodoItem updatedTodoItem = new TodoItem("implement code", "person4", "12/03/2024");
        todoTasks.save(updatedTodoItem);
// Act
        todoTasks.update(1, updatedTodoItem);

        // Assert
        List<TodoItem> todoList = todoTasks.getTodoList();
        assertEquals(1, todoList.size());
        assertEquals(updatedTodoItem, todoList.get(0));
    }

    @Test
    void deleteTodoItem() {
        // Arrange
        TodoTasks todoTasks = new TodoTasks();
        TodoItem todoItemToDelete = new TodoItem("deploy code", "person5", "12/02/2023");
        todoTasks.save(todoItemToDelete);

        // Act
        todoTasks.delete(0);

        // Assert
        List<TodoItem> todoList = todoTasks.getTodoList();
        assertEquals(0, todoList.size());
    }

    @Test
    void retrieveTodoItem() {
        // Arrange
        TodoTasks todoTasks = new TodoTasks();
        TodoItem expectedTodoItem = new TodoItem("deploy code", "person5", "12/02/2023");
        todoTasks.save(expectedTodoItem);

        // Act
        TodoItem retrievedTodoItem = todoTasks.retrieve(0);

        // Assert
        assertEquals(expectedTodoItem, retrievedTodoItem);
    }

    @Test
    void retrieveAllTodoItems() {
        // Arrange
        TodoTasks todoTasks = new TodoTasks();
        TodoItem todoItem1 = new TodoItem("code", "person1", "12/02/2023");
        TodoItem todoItem2 = new TodoItem("debug", "person2", "12/02/2024");
        todoTasks.save(todoItem1);
        todoTasks.save(todoItem2);

        // Act
        List<TodoItem> retrievedTodoItems = todoTasks.retrieveAll();

        // Assert
        assertEquals(2, retrievedTodoItems.size());
        assertTrue(retrievedTodoItems.contains(todoItem1));
        assertTrue(retrievedTodoItems.contains(todoItem2));
    }
}
