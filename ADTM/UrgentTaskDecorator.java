package ADTM;

public class UrgentTaskDecorator extends TaskDecorator {

    public UrgentTaskDecorator(Task decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public String toString() {
        return decoratedTask.toString() + " [Urgent]";
    }
}

