package model;

import util.ActivityLogger;

/**
 *
 * A representation of Event messages resulting from app activities
 * Maps Events and Processes to generate readable texts [String]
 * Events are either INITIALIZING, INPROGRESS, FINALIZING or TERMINATED
 *
 *
 */

public class AppMessage {
    public AppMessage(
            Media media,
            AppProcess process,
            LogMessageType messageType) {
        this.process = process;
        this.messageType = messageType;
        this.media = media;
    }


    private final AppProcess process;
    private final LogMessageType messageType;
    private final Media media;

    private String whichEvent(AppEvent event) {
        return switch (event) {
            case TERMINATED -> "Process " + this.process + " of " + media.getName() + " terminated :- ";
            case INPROGRESS -> "Process " + this.process + " of " + media.getName() + " in progress...";
            case FINALIZING -> "Finalizing " + this.process + " of " + media.getName();
            default -> "Generating " + this.process + " of " + media.getName();
        };
    }

    public void write(AppEvent event) {
        dumpToLogger(whichEvent(event));
    }

    public void write(AppEvent event, String exceptionString) {
        dumpToLogger(whichEvent(event) + exceptionString);
    }

    private void dumpToLogger(String message) {
        ActivityLogger activityLogger = new ActivityLogger(message, messageType);
        activityLogger.run();
    }
}
