package ADTM;

public class ConflictDetectionObserver implements ConflictObserver {

    @Override
    public void notifyConflict(Task newTask, Task existingTask) {
        System.out.println("Conflict detected: " + newTask.getDescription() + " conflicts with " + existingTask.getDescription());
    }
}
