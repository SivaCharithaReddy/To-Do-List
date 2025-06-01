package todolist;
import java.io.*;
import java.util.*;

public class TaskManager {
    private Map<Integer, Task> tasks = new HashMap<>();
    private final String fileName = "tasks.ser";
    private int nextId = 1;

    public TaskManager() {
        loadTasks();
    }

    public void add(String desc, Category category) {
        Task task = new Task(nextId++, desc, category);
        tasks.put(task.getId(), task);
        save();
        System.out.println("Task added.");
    }

    public void update(int id, String desc, Category category, boolean done) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setDescription(desc);
            task.setCategory(category);
            task.setDone(done);
            save();
            System.out.println("Task updated.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void delete(int id) {
        if (tasks.remove(id) != null) {
            save();
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void list() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task t : tasks.values()) {
                System.out.println(t);
            }
        }
    }

    public boolean exists(int id) {
        return tasks.containsKey(id);
    }

    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(tasks);
            out.writeInt(nextId);
        } catch (Exception e) {
            System.out.println("Failed to save tasks.");
        }
    }

    private void loadTasks() {
        File file = new File(fileName);
        if (!file.exists())
            return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            tasks = (Map<Integer, Task>) in.readObject();
            nextId = in.readInt();
        } catch (Exception e) {
            System.out.println("No saved tasks found.");
        }
    }
}
