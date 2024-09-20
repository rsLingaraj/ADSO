package ADTM;

public class CompletedTaskDecorator extends TaskDecorator {

    public CompletedTaskDecorator(Task decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public String toString() {
        return decoratedTask.toString() + " [Completed]";
    }
}

