/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registrationandloginfeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Keabetswe Masole
 */
public class WelcomeToEasyKanbanTest {
    
    public WelcomeToEasyKanbanTest() {
    }

    @Test
   public void testRunApplications() {
        WelcomeToEasyKanban manager = new WelcomeToEasyKanban();
        List<Map<String, String>> tasks = new ArrayList<>();

        // Adds task.
        addTaskTest(manager, tasks, "Edward Harrison", "Create Add Features", "Edward", "Harrison", "8", "Doing");
        addTaskTest(manager, tasks, "Mike", "Create Login", "Mike", "Smith", "5", "To Do");
        addTaskTest(manager, tasks, "Glenda Oberholzer", "Add Arrays", "Glenda", "Oberholzer", "11", "To Do");
        addTaskTest(manager, tasks, "Samantha Paulson", "Create Reports", "Samantha", "Paulson", "2", "Done");
        

        // Display tasks
        displayTasksTest(manager, tasks);

        // Delete a task
        deleteTaskTest(manager, tasks, "MI:1:ITH");

        // Search for a task
        searchTaskTest(manager, tasks, "ED:0:SON");

        // Exit the application
        exitTest(manager);
    }

    private void addTaskTest(WelcomeToEasyKanban manager, List<Map<String, String>> tasks, String taskName, String taskDescription,
                             String devFirstName, String devLastName, String taskDuration, String taskStatus) {
        // Simulating user input for addTask
        Map<String, String> task = new HashMap<>();
        task.put("Task Name", taskName);
        task.put("Task Number", String.valueOf(manager.taskNumber));
        task.put("Task Description", taskDescription);
        task.put("Developer Details", devFirstName + " " + devLastName);
        task.put("Task Duration", taskDuration);
        task.put("Task ID", manager.generateTaskID(taskName, manager.taskNumber, devLastName));
        task.put("Task Status", taskStatus);
        tasks.add(task);
        
    }


    private void displayTasksTest(WelcomeToEasyKanban manager, List<Map<String, String>> tasks) {
        // Simulate displaying tasks
        manager.displayTasks(tasks);
    }

    private void deleteTaskTest(WelcomeToEasyKanban manager, List<Map<String, String>> tasks, String taskID) {
        Iterator<Map<String, String>> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Map<String, String> task = iterator.next();
            if (task.get("Task ID").equals(taskID)) {
                iterator.remove();
                break;
            }
        }
    }

    public void searchTaskTest(WelcomeToEasyKanban manager, List<Map<String, String>> tasks, String taskID) {
        boolean found = false;
        for (Map<String, String> task : tasks) {
            if (task.get("Task ID").equals(taskID)) {
                found = true;
                break;
            }
        }
        assertTrue(found, "Task ID not found in search.");
    }

    private void exitTest(WelcomeToEasyKanban manager) {
        // Simulating exit action (not directly testable here)
        System.out.println("Goodbye!");
    }
}