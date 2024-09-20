package ADTM;

public class AddTaskCommand implements TaskCommand {
    private ScheduleManager scheduleManager;
    private Task task;

    public AddTaskCommand(ScheduleManager scheduleManager, Task task) {
        this.scheduleManager = scheduleManager;
        this.task = task;
    }

    @Override
    public void execute() {
        scheduleManager.addTask(task);
    }

    @Override
    public void undo() {
        scheduleManager.getTasks().remove(task);
        System.out.println("Task removed: " + task.getDescription());
    }
}

