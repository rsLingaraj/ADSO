package ADTM;
public abstract class TaskDecorator extends Task {
    protected Task decoratedTask;

    public TaskDecorator(Task decoratedTask) {
        super(decoratedTask.getDescription(), decoratedTask.getStartTime(), decoratedTask.getEndTime(), decoratedTask.getPriorityLevel());
        this.decoratedTask = decoratedTask;
    }

    @Override
    public String getDescription() {
        return decoratedTask.getDescription();
    }

    @Override
    public String getStartTime() {
        return decoratedTask.getStartTime();
    }

    @Override
    public String getEndTime() {
        return decoratedTask.getEndTime();
    }

    @Override
    public String getPriorityLevel() {
        return decoratedTask.getPriorityLevel();
    }

    @Override
    public String toString() {
        return decoratedTask.toString();
    }
}

