package ADTM;

import java.util.ArrayList;
import java.util.List;

public class ExternalCalendarSystem {
    private List<String> externalEvents;

    public ExternalCalendarSystem() {
        this.externalEvents = new ArrayList<>();
    }

    public void addEvent(String description, String startTime, String endTime) {
        String event = startTime + " - " + endTime + ": " + description;
        externalEvents.add(event);
        System.out.println("Event added to external calendar: " + event);
    }

    public List<String> getEvents() {
        return externalEvents;
    }
}
