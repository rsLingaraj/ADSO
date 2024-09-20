package ADTM;

public class RemoveTaskCommand implements TaskCommand {
    private ScheduleManager scheduleManager;
    private Task task;

    public RemoveTaskCommand(ScheduleManager scheduleManager, Task task) {
        this.scheduleManager = scheduleManager;
        this.task = task;
    }

    @Override
    public void execute() {
        if (scheduleManager.getTasks().contains(task)) {
            scheduleManager.getTasks().remove(task);
            System.out.println("Task removed: " + task.getDescription());
        } else {
            System.out.println("Task not found: " + task.getDescription());
        }
    }

    @Override
    public void undo() {
        scheduleManager.addTask(task);
    }
}

