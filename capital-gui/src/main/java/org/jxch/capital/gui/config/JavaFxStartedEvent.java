package org.jxch.capital.gui.config;

import org.springframework.context.ApplicationEvent;

public class JavaFxStartedEvent extends ApplicationEvent {

    public JavaFxStartedEvent(String message) {
        super(message);
    }

    public String getMessage() {
        return (String) getSource();
    }

}
