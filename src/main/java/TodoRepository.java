import java.util.List;

public interface TodoRepository {
    public void save(TodoItem todo);

    public void update(long id,TodoItem updatedTodoItem);
    public void delete(long id);
    public TodoItem retrieve(long id);

    public List<TodoItem> retrieveAll();
}
