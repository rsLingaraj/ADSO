package ADTM;

public interface ConflictObserver {
    void notifyConflict(Task newTask, Task existingTask);

}

