
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No command provided.");
            return;
        }

        TaskManager.loadTasks();
        String command = args[0];

        switch (command) {
            case "add":
                TaskManager.addTask(args[1]);
                break;
            case "update":
                TaskManager.updateTask(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                TaskManager.deleteTask(Integer.parseInt(args[1]));
                break;
            case "mark-done":
                TaskManager.markStatus(Integer.parseInt(args[1]), "done");
                break;
            case "mark-in-progress":
                TaskManager.markStatus(Integer.parseInt(args[1]), "in-progress");
                break;
            case "list":
                TaskManager.listTasks(args.length == 2 ? args[1] : "all");
                break;
            default:
                System.out.println("Unknown command.");
        }
    }
}
