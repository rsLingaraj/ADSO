package com.astronaut;

import java.time.LocalDateTime;

public class LoggerUtility {
    public static void logInfo(String message) {
        System.out.println("[INFO] " + LocalDateTime.now() + " : " + message);
    }

    public static void logWarning(String message) {
        System.out.println("[WARNING] " + LocalDateTime.now() + " : " + message);
    }

    public static void logError(String message) {
        System.out.println("[ERROR] " + LocalDateTime.now() + " : " + message);
    }
}