package org.jxch.capital.gui.config;

import org.springframework.context.ApplicationEvent;

public class CapitalGuiAppStartedEvent extends ApplicationEvent {

    public CapitalGuiAppStartedEvent(String message) {
        super(message);
    }

    public String getMessage() {
        return (String) getSource();
    }

}
