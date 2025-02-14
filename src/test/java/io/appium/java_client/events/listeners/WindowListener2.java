package io.appium.java_client.events.listeners;

import static java.lang.String.format;

import io.appium.java_client.events.api.general.WindowEventListener;
import org.openqa.seleniumone.Dimension;
import org.openqa.seleniumone.Point;
import org.openqa.seleniumone.WebDriver;

public class WindowListener2 extends TestListener implements WindowEventListener {

    @Override protected void add() {
        SingleListeners.listeners.put(WindowListener2.class, this);
    }

    @Override public void beforeWindowChangeSize(WebDriver driver, WebDriver.Window window,
        Dimension targetSize) {
        messages.add("Externally defined listener: Attempt to change size of the window. "
            + "The height is " + targetSize.getHeight()
            + " the width is " + targetSize.getWidth());
    }

    @Override public void afterWindowChangeSize(WebDriver driver, WebDriver.Window window,
        Dimension targetSize) {
        messages.add("Externally defined listener: Size of the window has "
            + "been changed. The height is " + targetSize.getHeight()
            + " the width is " + targetSize.getWidth());
    }

    @Override
    public void beforeWindowIsMoved(WebDriver driver, WebDriver.Window window, Point targetPoint) {
        messages.add("Externally defined listener: Attempt to change position of the window. "
            + "The X is " + targetPoint.getX()
            + " the Y is " + targetPoint.getY());
    }

    @Override
    public void afterWindowIsMoved(WebDriver driver, WebDriver.Window window, Point targetPoint) {
        messages.add("Externally defined listener: The position the window has been changed. "
            + "The X is " + targetPoint.getX()
            + " the Y is " + targetPoint.getY());
    }

    @Override public void beforeWindowIsMaximized(WebDriver driver, WebDriver.Window window) {
        messages.add("Externally defined listener: Attempt to maximize the window.");
    }

    @Override public void afterWindowIsMaximized(WebDriver driver, WebDriver.Window window) {
        messages.add("Externally defined listener: The window has been maximized");
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        messages.add(format("Externally defined listener: Attempt to switch to window %s", windowName));
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        messages.add(format("Externally defined listener: driver is switched to window %s", windowName));
    }
}
