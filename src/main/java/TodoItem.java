public class TodoItem {


    private String title;
    private String personToCompleteTask ;
    private String dueDate;

    private long id;

    public TodoItem(String title, String personToCompleteTask, String dueDate) {
        this.id=id;
        this.title = title;
        this.personToCompleteTask = personToCompleteTask;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "title='" + title + '\'' +
                ", personToCompleteTask='" + personToCompleteTask + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPersonToCompleteTask() {
        return personToCompleteTask;
    }

    public void setPersonToCompleteTask(String personToCompleteTask) {
        this.personToCompleteTask = personToCompleteTask;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
