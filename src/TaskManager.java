
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class TaskManager {
    private static final String FILE_NAME = "tasks.json";
    private static List<Task> tasks = new ArrayList<>();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void loadTasks() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            tasks = gson.fromJson(reader, new TypeToken<List<Task>>() {}.getType());
        } catch (IOException e) {
            tasks = new ArrayList<>();
        }
    }

    public static void saveTasks() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Failed to save tasks.");
        }
    }

    public static void addTask(String desc) {
        int id = tasks.size() + 1;
        tasks.add(new Task(id, desc));
        saveTasks();
        System.out.println("Task added successfully (ID: " + id + ")");
    }

    public static void updateTask(int id, String newDesc) {
        for (Task task : tasks) {
            if (task.id == id) {
                task.description = newDesc;
                task.updatedAt = LocalDateTime.now();
                saveTasks();
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public static void deleteTask(int id) {
        tasks.removeIf(task -> task.id == id);
        saveTasks();
    }

    public static void markStatus(int id, String status) {
        for (Task task : tasks) {
            if (task.id == id) {
                task.status = status;
                task.updatedAt = LocalDateTime.now();
                saveTasks();
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public static void listTasks(String filter) {
        for (Task task : tasks) {
            if (filter.equals("all") || task.status.equals(filter)) {
                System.out.println(task.id + ": " + task.description + " [" + task.status + "]");
            }
        }
    }
}
