
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TodoRepository todoRepository = new TodoTasks();
        TodoService todoService = new TodoService(todoRepository, scanner);

        while (true) {
            System.out.print("\nEnter (s) save, (u) update, (d) delete, or (r) to retrieve todo items: ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("q")) {
                break;
            }

            if (response.equalsIgnoreCase("r")) {
                todoService.displayTodos();
            } else if (response.equalsIgnoreCase("s")) {
                todoService.saveTodo();
            } else if (response.equalsIgnoreCase("u")) {
                todoService.updateTodo();
            } else if (response.equalsIgnoreCase("d")) {
                todoService.deleteTodo();
            } else {
                System.out.println("You entered an invalid option");
            }
        }

        scanner.close();
    }
}
