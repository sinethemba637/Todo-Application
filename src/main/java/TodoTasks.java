import java.util.ArrayList;
import java.util.List;


public class TodoTasks implements TodoRepository {


    private List<TodoItem> todoList = new ArrayList<>();
    public List<TodoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoItem> todoList) {
        this.todoList = todoList;
    }

    @Override
    public void save(TodoItem todo) {

        if (todo != null) {
            todo.setId(todoList.size());
            todoList.add(todo);
        }
    }

    @Override
    public void update(long id, TodoItem updatedTodoItem) {
        TodoItem todoItem = retrieve(id);
        int index = -1;


        if (todoItem != null) {
            index = todoList.indexOf(todoItem);
        }

        if (index != -1 && index < todoList.size()) {
            todoList.set(index, updatedTodoItem);
        }
    }

    @Override
    public void delete(long id) {
        TodoItem todoItem = retrieve(id);
        if (todoItem != null) {
            todoList.remove(todoItem);
        }
    }

    @Override
    public TodoItem retrieve(long id) {
        for (TodoItem item : todoList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<TodoItem> retrieveAll() {
        return new ArrayList<>(todoList);
    }
}



