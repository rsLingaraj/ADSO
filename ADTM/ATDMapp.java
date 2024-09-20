package ADTM;
public class ATDMapp {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskFactory taskFactory = new TaskFactory();
        ExternalCalendarSystem ecs = new ExternalCalendarSystem();
        ExternalCalendarAdapter eca = new ExternalCalendarAdapter(ecs);

        // Create some tasks
        Task t1 = taskFactory.createTask("Morning Exercise", "07:00", "08:00", "High");
        Task t2 = taskFactory.createTask("Team Meeting", "09:00", "10:00", "Medium");

        // Add tasks to schedule
        scheduleManager.addTask(t1);
        scheduleManager.addTask(t2);

        // Add tasks to external calendar via the adapter
        eca.addTaskToExternalCalendar(t1);
        eca.addTaskToExternalCalendar(t2);

        // View tasks in the external calendar
        eca.showExternalCalendarEvents();
    }
}
