/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appium.java_client.events;

import io.appium.java_client.events.api.Listener;
import io.appium.java_client.events.api.general.AlertEventListener;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import io.appium.java_client.events.api.general.ElementEventListener;
import io.appium.java_client.events.api.general.JavaScriptEventListener;
import io.appium.java_client.events.api.general.ListensToException;
import io.appium.java_client.events.api.general.NavigationEventListener;
import io.appium.java_client.events.api.general.SearchingEventListener;
import io.appium.java_client.events.api.general.WindowEventListener;
import io.appium.java_client.events.api.mobile.ContextEventListener;
import io.appium.java_client.events.api.mobile.RotationEventListener;
import org.openqa.seleniumone.Alert;
import org.openqa.seleniumone.By;
import org.openqa.seleniumone.Dimension;
import org.openqa.seleniumone.OutputType;
import org.openqa.seleniumone.Point;
import org.openqa.seleniumone.ScreenOrientation;
import org.openqa.seleniumone.WebDriver;
import org.openqa.seleniumone.WebElement;
import org.openqa.seleniumone.support.events.WebDriverEventListener;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class DefaultListener
    implements Listener, AppiumWebDriverEventListener, ListensToException, SearchingEventListener,
    NavigationEventListener, JavaScriptEventListener, ElementEventListener, AlertEventListener,
    WindowEventListener, ContextEventListener, RotationEventListener {

    private final List<Listener> listeners = new ArrayList<>();

    private Object dispatcher = Proxy.newProxyInstance(Listener.class.getClassLoader(),
        new Class[] {AlertEventListener.class, ContextEventListener.class,
            ElementEventListener.class, JavaScriptEventListener.class, ListensToException.class,
            NavigationEventListener.class, RotationEventListener.class,
            SearchingEventListener.class, WindowEventListener.class, WebDriverEventListener.class},
        new ListenerInvocationHandler(listeners));

    @Override public void beforeNavigateTo(String url, WebDriver driver) {
        ((NavigationEventListener) dispatcher).beforeNavigateTo(url, driver);
    }

    @Override public void afterNavigateTo(String url, WebDriver driver) {
        ((NavigationEventListener) dispatcher).afterNavigateTo(url, driver);
    }

    @Override public void beforeNavigateBack(WebDriver driver) {
        ((NavigationEventListener) dispatcher).beforeNavigateBack(driver);
    }

    @Override public void afterNavigateBack(WebDriver driver) {
        ((NavigationEventListener) dispatcher).afterNavigateBack(driver);
    }

    @Override public void beforeNavigateForward(WebDriver driver) {
        ((NavigationEventListener) dispatcher).beforeNavigateForward(driver);
    }

    @Override public void afterNavigateForward(WebDriver driver) {
        ((NavigationEventListener) dispatcher).afterNavigateForward(driver);
    }

    @Override public void beforeNavigateRefresh(WebDriver driver) {
        ((NavigationEventListener) dispatcher).beforeNavigateRefresh(driver);
    }

    @Override public void afterNavigateRefresh(WebDriver driver) {
        ((NavigationEventListener) dispatcher).afterNavigateRefresh(driver);
    }

    @Override public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        ((SearchingEventListener) dispatcher).beforeFindBy(by, element, driver);
    }

    @Override public void afterFindBy(By by, WebElement element, WebDriver driver) {
        ((SearchingEventListener) dispatcher).afterFindBy(by, element, driver);
    }

    @Override public void beforeClickOn(WebElement element, WebDriver driver) {
        ((ElementEventListener) dispatcher).beforeClickOn(element, driver);
    }

    @Override public void afterClickOn(WebElement element, WebDriver driver) {
        ((ElementEventListener) dispatcher).afterClickOn(element, driver);
    }

    @Override public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        ((ElementEventListener) dispatcher).beforeChangeValueOf(element, driver);
    }

    @Override public void beforeChangeValueOf(WebElement element, WebDriver driver,
        CharSequence[] keysToSend) {
        ((ElementEventListener) dispatcher).beforeChangeValueOf(element, driver, keysToSend);
    }

    @Override public void afterChangeValueOf(WebElement element, WebDriver driver) {
        ((ElementEventListener) dispatcher).afterChangeValueOf(element, driver);
    }

    @Override public void afterChangeValueOf(WebElement element, WebDriver driver,
        CharSequence[] keysToSend) {
        ((ElementEventListener) dispatcher).afterChangeValueOf(element, driver, keysToSend);
    }

    @Override public void beforeScript(String script, WebDriver driver) {
        ((JavaScriptEventListener) dispatcher).beforeScript(script, driver);
    }

    @Override public void afterScript(String script, WebDriver driver) {
        ((JavaScriptEventListener) dispatcher).afterScript(script, driver);
    }

    @Override public void onException(Throwable throwable, WebDriver driver) {
        ((ListensToException) dispatcher).onException(throwable, driver);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        ((WebDriverEventListener) dispatcher).beforeGetScreenshotAs(target);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        ((WebDriverEventListener) dispatcher).afterGetScreenshotAs(target, screenshot);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        ((ElementEventListener) dispatcher).beforeGetText(element, driver);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        ((ElementEventListener) dispatcher).afterGetText(element, driver, text);
    }

    public void add(Collection<Listener> listeners) {
        this.listeners.addAll(listeners);
    }

    @Override public void beforeAlertAccept(WebDriver driver, Alert alert) {
        ((AlertEventListener) dispatcher).beforeAlertAccept(driver, alert);
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        ((WebDriverEventListener) dispatcher).beforeAlertAccept(driver);
    }

    @Override public void afterAlertAccept(WebDriver driver, Alert alert) {
        ((AlertEventListener) dispatcher).afterAlertAccept(driver, alert);
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        ((WebDriverEventListener) dispatcher).afterAlertAccept(driver);
    }

    @Override public void afterAlertDismiss(WebDriver driver, Alert alert) {
        ((AlertEventListener) dispatcher).afterAlertDismiss(driver, alert);
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        ((WebDriverEventListener) dispatcher).afterAlertDismiss(driver);
    }

    @Override public void beforeAlertDismiss(WebDriver driver, Alert alert) {
        ((AlertEventListener) dispatcher).beforeAlertDismiss(driver, alert);
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        ((WebDriverEventListener) dispatcher).beforeAlertDismiss(driver);
    }

    @Override public void beforeAlertSendKeys(WebDriver driver, Alert alert, String keys) {
        ((AlertEventListener) dispatcher).beforeAlertSendKeys(driver, alert, keys);
    }

    @Override public void afterAlertSendKeys(WebDriver driver, Alert alert, String keys) {
        ((AlertEventListener) dispatcher).afterAlertSendKeys(driver, alert, keys);
    }

    @Override public void beforeWindowChangeSize(WebDriver driver, WebDriver.Window window,
        Dimension targetSize) {
        ((WindowEventListener) dispatcher).beforeWindowChangeSize(driver, window, targetSize);
    }

    @Override public void afterWindowChangeSize(WebDriver driver, WebDriver.Window window,
        Dimension targetSize) {
        ((WindowEventListener) dispatcher).afterWindowChangeSize(driver, window, targetSize);
    }

    @Override
    public void beforeWindowIsMoved(WebDriver driver, WebDriver.Window window, Point targetPoint) {
        ((WindowEventListener) dispatcher).beforeWindowIsMoved(driver, window, targetPoint);
    }

    @Override
    public void afterWindowIsMoved(WebDriver driver, WebDriver.Window window, Point targetPoint) {
        ((WindowEventListener) dispatcher).afterWindowIsMoved(driver, window, targetPoint);
    }

    @Override public void beforeWindowIsMaximized(WebDriver driver, WebDriver.Window window) {
        ((WindowEventListener) dispatcher).beforeWindowIsMaximized(driver, window);
    }

    @Override public void afterWindowIsMaximized(WebDriver driver, WebDriver.Window window) {
        ((WindowEventListener) dispatcher).afterWindowIsMaximized(driver, window);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        ((WebDriverEventListener) dispatcher).beforeSwitchToWindow(windowName, driver);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        ((WebDriverEventListener) dispatcher).afterSwitchToWindow(windowName, driver);
    }

    @Override public void beforeSwitchingToContext(WebDriver driver, String context) {
        ((ContextEventListener) dispatcher).beforeSwitchingToContext(driver, context);
    }

    @Override public void afterSwitchingToContext(WebDriver driver, String context) {
        ((ContextEventListener) dispatcher).afterSwitchingToContext(driver, context);
    }

    @Override public void beforeRotation(WebDriver driver, ScreenOrientation orientation) {
        ((RotationEventListener) dispatcher).beforeRotation(driver, orientation);
    }

    @Override public void afterRotation(WebDriver driver, ScreenOrientation orientation) {
        ((RotationEventListener) dispatcher).afterRotation(driver, orientation);
    }
}
