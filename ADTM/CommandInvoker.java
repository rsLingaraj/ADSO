package ADTM;

import java.util.Stack;

public class CommandInvoker {
    private Stack<TaskCommand> commandHistory = new Stack<>();

    public void executeCommand(TaskCommand command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            TaskCommand lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No command to undo.");
        }
    }
}

