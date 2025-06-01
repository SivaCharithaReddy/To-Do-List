# 📝 To-Do List Manager (Java Console App)
A simple Java console application that allows users to manage personal tasks with categories, status updates, and persistent storage.

## 📦 Project Structure
todolist/
├── Task.java          // Task model class
├── TaskManager.java   // Logic for task operations and persistence
└── Category.java      // Enum for task categories

## 📋 Features
- ✅ Add new tasks with a category
- ✏️ Update task description, category, and completion status
- ❌ Delete tasks by ID
- 📃 List all tasks
- 💾 Save tasks to a file (`tasks.ser`) and load them on startup
- 🗂️ Categorize tasks as: `PERSONAL`, `WORK`, `HOBBY`, `OTHER`

## 🚀 Getting Started

### ✅ Prerequisites
- Java JDK 8 or higher

### 🛠 Compilation
Navigate to the `todolist/` directory and run:

```bash
javac *.java

### 📦 Running the App

You will need to create a small interface (like `Main.java`) to interact with the `TaskManager`. Example:
public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.add("Buy groceries", Category.PERSONAL);
        tm.list();
    }
}

Then compile and run:

```bash
javac Main.java
java Main

## 📂 Example Output
Task added.
ID: 1 | [ ] Buy groceries (PERSONAL)
Task updated.
ID: 1 | [X] Buy groceries (PERSONAL)

## 🧠 How It Works
* All tasks are stored in a `HashMap<Integer, Task>`, with unique IDs.
* Data is serialized to a file called `tasks.ser`.
* Tasks are automatically loaded from the file when the app starts.
  
## 🔧 Future Enhancements
* Add due dates and priority levels
* Implement sorting and filtering
* Build a GUI version using JavaFX or Swing

## 📜 License
This project is for educational use and learning purposes.
