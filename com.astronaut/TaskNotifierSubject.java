package com.astronaut;

import java.util.ArrayList;
import java.util.List;

public class TaskNotifierSubject {
    private List<TaskObserver> observers = new ArrayList<>();

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.update(message);
        }
    }
}
