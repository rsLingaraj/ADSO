package com.astronaut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager extends TaskNotifierSubject {
    private List<Task> taskList;
    private static ScheduleManager instance;

    private ScheduleManager() {
        taskList = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public boolean addTask(Task task) {
        if (hasConflict(task)) {
            notifyObservers("Conflict detected with task: " + task.getDescription());
            LoggerUtility.logWarning("Task conflict: " + task.getDescription());
            return false;
        }
        taskList.add(task);
        LoggerUtility.logInfo("Task added: " + task.getDescription());
        return true;
    }

    public boolean removeTask(String description) {
        for (Task task : taskList) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                taskList.remove(task);
                LoggerUtility.logInfo("Task removed : " + description);
                return true;
            }
        }
        LoggerUtility.logWarning("Task not found: " + description);
        return false;
    }

    public void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        taskList.sort(Comparator.comparing(Task::getStartTime));
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public boolean editTask(String oldDescription, String newDescription, String newStartTime, String newEndTime, Task.PriorityLevel newPriority) {
        for (Task task : taskList) {
            if (task.getDescription().equalsIgnoreCase(oldDescription)) {
                task.setDescription(newDescription);
                task.setStartTime(newStartTime);
                task.setEndTime(newEndTime);
                task.setPriority(newPriority);
                notifyObservers("Task edited: " + oldDescription + " updated to " + newDescription);
                LoggerUtility.logInfo("Task edited successfully: " + oldDescription + " updated to " + newDescription);
                return true;
            }
        }
        LoggerUtility.logWarning("Task not found for editing: " + oldDescription);
        return false;
    }

    public boolean markTaskAsCompleted(String description) {
        for (Task task : taskList) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markAsCompleted();
                notifyObservers("Task completed: " + description);
                LoggerUtility.logInfo("Task marked as completed: " + description);
                return true;
            }
        }
        LoggerUtility.logWarning("Task not found to mark as completed: " + description);
        return false;
    }

    public void viewTasksByPriority(Task.PriorityLevel priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getPriority() == priority) {
                filteredTasks.add(task);
            }
        }

        if (filteredTasks.isEmpty()) {
            LoggerUtility.logInfo("No tasks found with priority: " + priority);
            System.out.println("No tasks found with priority: " + priority);
            return;
        }

        filteredTasks.sort(Comparator.comparing(Task::getStartTime));
        for (Task task : filteredTasks) {
            System.out.println(task);
        }
        LoggerUtility.logInfo("Tasks with priority " + priority + " displayed successfully.");
    }

    private boolean hasConflict(Task newTask) {
        for (Task task : taskList) {
            if ((newTask.getStartTime().compareTo(task.getStartTime()) >= 0 && newTask.getStartTime().compareTo(task.getEndTime()) < 0) ||
                    (newTask.getEndTime().compareTo(task.getStartTime()) > 0 && newTask.getEndTime().compareTo(task.getEndTime()) <= 0)) {
                return true;
            }
        }
        return false;
    }
}