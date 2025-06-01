package todolist;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        int option;

        do {
            printMenu();
            option = getInt(input, "Choose an option: ");

            switch (option) {
                case 1:
                    addTask(input, manager);
                    break;
                case 2:
                    updateTask(input, manager);
                    break;
                case 3:
                    deleteTask(input, manager);
                    break;
                case 4:
                    manager.list();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 5);
    }

    static void printMenu() {
        System.out.println("\nTo-Do List Menu");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. View Tasks");
        System.out.println("5. Exit");
    }

    static void addTask(Scanner input, TaskManager manager) {
        System.out.print("Enter task description: ");
        String desc = input.nextLine().trim();
        if (desc.isEmpty()) {
            System.out.println("Description is required.");
            return;
        }
        Category cat = chooseCategory(input);
        if (cat != null)
            manager.add(desc, cat);
    }

    static void updateTask(Scanner input, TaskManager manager) {
        int id = getInt(input, "Enter task ID: ");
        if (!manager.exists(id)) {
            System.out.println("Task not found.");
            return;
        }

        System.out.print("Enter new description: ");
        String desc = input.nextLine().trim();
        if (desc.isEmpty()) {
            System.out.println("Description is required.");
            return;
        }

        Category cat = chooseCategory(input);
        if (cat == null)
            return;

        boolean done = getBool(input, "Is the task done? (yes/no): ");
        manager.update(id, desc, cat, done);
    }

    static void deleteTask(Scanner input, TaskManager manager) {
        int id = getInt(input, "Enter task ID to delete: ");
        manager.delete(id);
    }

    static int getInt(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static boolean getBool(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            String ans = input.nextLine().trim().toLowerCase();
            if (ans.equals("yes") || ans.equals("y") || ans.equals("true"))
                return true;
            if (ans.equals("no") || ans.equals("n") || ans.equals("false"))
                return false;
            System.out.println("Enter yes or no.");
        }
    }

    static Category chooseCategory(Scanner input) {
        System.out.println("Available categories:");
        for (Category c : Category.values())
            System.out.println("- " + c);
        System.out.print("Enter the category: ");
        String choice = input.nextLine().trim().toUpperCase();
        try {
            return Category.valueOf(choice);
        } catch (Exception e) {
            System.out.println("Invalid category.");
            return null;
        }
    }
}
