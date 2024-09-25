package com.astronaut;

public class Task {
    public enum PriorityLevel {
        HIGH, MEDIUM, LOW
    }

    private String description;
    private String startTime;
    private String endTime;
    private PriorityLevel priority;
    private boolean completed;

    public Task(String description, String startTime, String endTime, PriorityLevel priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false; // Initially, tasks are not completed
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }

    public void markAsCompleted() {
        this.completed = true;
        LoggerUtility.logInfo("Task marked as completed: " + description);
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        String status = completed ? "[Completed]" : "[Pending]";
        return startTime + " - " + endTime + ": " + description + " [" + priority + "] " + status;
    }
}
