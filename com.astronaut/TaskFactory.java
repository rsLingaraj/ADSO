package com.astronaut;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, Task.PriorityLevel priority) throws Exception {
        if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime)) {
            throw new Exception("Invalid time format.");
        }
        return new Task(description, startTime, endTime, priority);
    }

    private static boolean isValidTimeFormat(String time) {
        // Simple validation for HH:mm format
        return time.matches("^([01]\\d|2[0-3]):([0-5]\\d)$");
    }
}