package io.appium.java_client.events.listeners;

import io.appium.java_client.events.api.general.ListensToException;
import org.openqa.seleniumone.WebDriver;

public class ExceptionListener2 extends TestListener implements ListensToException {
    @Override public void onException(Throwable throwable, WebDriver driver) {
        messages.add("Externally defined listener: The exception was thrown: " + throwable.getClass());
    }

    @Override protected void add() {
        SingleListeners.listeners.put(ExceptionListener2.class, this);
    }
}
