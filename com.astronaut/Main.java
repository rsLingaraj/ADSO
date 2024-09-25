package com.astronaut;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ScheduleManager scheduleManager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        // Add an observer for conflict notifications
        TaskObserver conflictNotifier = new TaskConflictNotifier();
        scheduleManager.addObserver(conflictNotifier);

        System.out.println("=== Welcome to Astronaut Daily Schedule Organizer ===");

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    viewAllTasks();
                    break;
                case 4:
                    editTask();
                    break;
                case 5:
                    markTaskAsCompleted();
                    break;
                case 6:
                    viewTasksByPriority();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting the application. will see later..");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a new task");
        System.out.println("2. Remove a task");
        System.out.println("3. View all tasks");
        System.out.println("4. Edit an existing task");
        System.out.println("5. Mark a task as completed");
        System.out.println("6. View tasks by priority");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Method to add a new task
    private static void addNewTask() {
        System.out.print("Enter task description: ");
        scanner.nextLine(); // Consume newline
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority as (HIGH, MEDIUM or LOW): ");
        String priorityInput = scanner.nextLine();
        Task.PriorityLevel priority = getPriority(priorityInput);

        try {
            Task task = TaskFactory.createTask(description, startTime, endTime, priority);
            boolean success = scheduleManager.addTask(task);
            if (success) {
                System.out.println("Task added successfully. No conflicts");
            } else {
                System.out.println("Task could not be added due to conflicts.");
            }
        } catch (Exception e) {
            System.out.println("Failed to add task: " + e.getMessage());
        }
    }

    // Method to remove a task
    private static void removeTask() {
        System.out.print("Enter task description to remove: ");
        scanner.nextLine(); // Consume newline
        String description = scanner.nextLine();
        boolean success = scheduleManager.removeTask(description);
        if (success) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // Method to view all tasks
    private static void viewAllTasks() {
        System.out.println("Displaying all tasks:");
        scheduleManager.viewTasks();
    }

    // Method to edit an existing task
    private static void editTask() {
        System.out.print("Enter the description of the task you want to edit: ");
        scanner.nextLine(); // Consume newline
        String oldDescription = scanner.nextLine();
        System.out.print("Enter new task description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new start time (HH:mm): ");
        String newStartTime = scanner.nextLine();
        System.out.print("Enter new end time (HH:mm): ");
        String newEndTime = scanner.nextLine();
        System.out.print("Enter new priority (HIGH, MEDIUM, LOW): ");
        String newPriorityInput = scanner.nextLine();
        Task.PriorityLevel newPriority = getPriority(newPriorityInput);

        boolean success = scheduleManager.editTask(oldDescription, newDescription, newStartTime, newEndTime, newPriority);
        if (success) {
            System.out.println("Task edited successfully.");
        } else {
            System.out.println("Failed to edit task. Task not found.");
        }
    }

    // Method to mark a task as completed
    private static void markTaskAsCompleted() {
        System.out.print("Enter task description to mark as completed: ");
        scanner.nextLine(); // Consume newline
        String description = scanner.nextLine();
        boolean success = scheduleManager.markTaskAsCompleted(description);
        if (success) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // Method to view tasks by priority
    private static void viewTasksByPriority() {
        System.out.print("Enter priority level to filter by (HIGH, MEDIUM, LOW): ");
        scanner.nextLine(); // Consume newline
        String priorityInput = scanner.nextLine();
        Task.PriorityLevel priority = getPriority(priorityInput);
        System.out.println("Displaying tasks with priority: " + priority);
        scheduleManager.viewTasksByPriority(priority);
    }

    // Helper method to convert user input to PriorityLevel
    private static Task.PriorityLevel getPriority(String priorityInput) {
        try {
            return Task.PriorityLevel.valueOf(priorityInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority level. Defaulting to LOW.");
            return Task.PriorityLevel.LOW;
        }
    }
}
