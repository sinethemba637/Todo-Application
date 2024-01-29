import java.util.Scanner;

public class TodoService {

    private final TodoRepository todoRepository;
    private final Scanner scanner;

    public TodoService(TodoRepository todoRepository, Scanner scanner) {
        this.todoRepository = todoRepository;
        this.scanner = new Scanner(System.in);

    }

    public void displayTodos() {
        System.out.println("----------- Todos -----------");
        for (TodoItem todoItem : todoRepository.retrieveAll()) {
            long todoId = todoItem.getId();
            String todoTitle = todoItem.getTitle();
            String dueDate = todoItem.getDueDate();
            String todoPersonToCompleteTask = todoItem.getPersonToCompleteTask();
            System.out.println("id: " + todoId + ", title=" + todoTitle + ", due date=" + dueDate + ", Person to complete task=" + todoPersonToCompleteTask);
        }
        System.out.println("task retrieved successfully");
    }

    public void saveTodo() {
        System.out.print("Enter description: ");
        String title = readInput();
        System.out.print("Enter your name: ");
        String person = readInput();
        System.out.print("Enter date: ");
        String dueDate = readInput();

        if (title != null && person != null && dueDate != null) {
            TodoItem todo = new TodoItem(title, person, dueDate);
            todoRepository.save(todo);
            System.out.println("Task saved successfully");
        } else {
            System.out.println("Invalid input. Task not saved.");
        }
    }

    public void updateTodo() {
        System.out.print("Enter todo id: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        TodoItem todoItem = todoRepository.retrieve(id);

        if (id <= 0 || todoItem == null) {
            System.out.println("Invalid input. Task not updated.");
            return;
        }

        System.out.print("Enter new description or enter to leave empty: ");
        String updatedDescription = readInput();

        System.out.print("Enter new name or enter to leave empty: ");
        String updatedName = readInput();

        System.out.print("Enter new due date or enter to leave empty: ");
        String updatedDueDate = readInput();

        updatedDescription = updatedDescription == null ? todoItem.getTitle() : updatedDescription;
        updatedName = updatedName == null ? todoItem.getPersonToCompleteTask() : updatedName;
        updatedDueDate = updatedDueDate == null ? todoItem.getDueDate() : updatedDueDate;

        TodoItem updatedTodoItem = new TodoItem(updatedDescription, updatedName, updatedDueDate);

        todoRepository.update(id, updatedTodoItem);
        System.out.println("Task updated successfully");
    }

    public void deleteTodo() {
        System.out.print("Enter todo id: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        TodoItem todo = todoRepository.retrieve(id);

        if (id <= 0 || todo == null) {
            System.out.println("Invalid input. Task not deleted.");
            return;
        }

        todoRepository.delete(id);
        System.out.println("Task deleted successfully");
    }

    private String readInput() {
        String input = scanner.nextLine();
        return input.isEmpty() ? null : input;
    }
}
