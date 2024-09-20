package ADTM;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<ConflictObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        // Check for conflicts
        for (Task existingTask : tasks) {
            if (hasConflict(task, existingTask)) {
                notifyObservers(task, existingTask);
                return;
            }
        }
        tasks.add(task);
        System.out.println("Task added: " + task.getDescription());
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void registerObserver(ConflictObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ConflictObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Task newTask, Task existingTask) {
        for (ConflictObserver observer : observers) {
            observer.notifyConflict(newTask, existingTask);
        }
    }

    private boolean hasConflict(Task newTask, Task existingTask) {
        // Check if the times overlap
        return newTask.getStartTime().compareTo(existingTask.getEndTime()) < 0 &&
                newTask.getEndTime().compareTo(existingTask.getStartTime()) > 0;
    }
}
