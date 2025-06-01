package todolist;
import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String description;
    private Category category;
    private boolean isDone;

    public Task(int id, String description, Category category) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.isDone = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public String toString() {
        return "ID: " + id + " | [" + (isDone ? "X" : " ") + "] " + description + " (" + category + ")";
    }
}
