package ADTM;

public class ExternalCalendarAdapter {
    private ExternalCalendarSystem externalCalendarSystem;

    public ExternalCalendarAdapter(ExternalCalendarSystem externalCalendarSystem) {
        this.externalCalendarSystem = externalCalendarSystem;
    }

    // This method will allow ScheduleManager tasks to be added to the external calendar
    public void addTaskToExternalCalendar(Task task) {
        externalCalendarSystem.addEvent(task.getDescription(), task.getStartTime(), task.getEndTime());
    }

    // You can also add other adapter methods to interact with the external calendar
    public void showExternalCalendarEvents() {
        System.out.println("External Calendar Events:");
        for (String event : externalCalendarSystem.getEvents()) {
            System.out.println(event);
        }
    }
}
