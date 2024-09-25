package com.astronaut;


public class TaskConflictNotifier implements TaskObserver {
    @Override
    public void update(String message) {
        System.out.println("[NOTIFICATION] " + message);
    }
}