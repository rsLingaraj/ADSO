package ADTM;

public class TaskFactory {

    public Task createTask(String description, String startTime, String endTime, String priority) {
        Task task = new Task(description, startTime, endTime, priority);
        switch (priority.toLowerCase()) {
            case "high" -> task.setPriorityLevel("High");
            case "medium" -> task.setPriorityLevel("Medium");
            case "low" -> task.setPriorityLevel("Low");
            default -> throw new IllegalArgumentException("Invalid priority level");
        }
        return task;
    }
}
