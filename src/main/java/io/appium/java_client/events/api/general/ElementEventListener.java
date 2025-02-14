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

package io.appium.java_client.events.api.general;

import io.appium.java_client.events.api.Listener;
import org.openqa.seleniumone.WebDriver;
import org.openqa.seleniumone.WebElement;

public interface ElementEventListener extends Listener {
    /**
     * Called before {@link WebElement#click WebElement.click()}.
     *
     * @param driver WebDriver
     * @param element the WebElement being used for the action
     */
    void beforeClickOn(WebElement element, WebDriver driver);

    /**
     * Called after {@link WebElement#click WebElement.click()}.
     * Not called, if an exception is thrown.
     *
     * @param driver WebDriver
     * @param element the WebElement being used for the action
     */
    void afterClickOn(WebElement element, WebDriver driver);

    /**
     * Called before {@link WebElement#clear WebElement.clear()},
     * {@link WebElement#sendKeys WebElement.sendKeys(...)}.
     *
     * @param driver WebDriver
     * @param element the WebElement being used for the action
     */
    void beforeChangeValueOf(WebElement element, WebDriver driver);

    /**
     * Called before {@link WebElement#clear WebElement.clear()},
     * {@link WebElement#sendKeys WebElement.sendKeys(...)}.
     *
     * @param driver WebDriver
     * @param element the WebElement being used for the action
     * @param keysToSend character sequence to send to the element
     */
    void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend);

    /**
     * Called after {@link WebElement#clear WebElement.clear()},
     * {@link WebElement#sendKeys WebElement.sendKeys(...)}.
     * Not called, if an exception is thrown.
     *
     * @param driver WebDriver
     * @param element the WebElement being used for the action
     */
    void afterChangeValueOf(WebElement element, WebDriver driver);

    /**
     * Called after {@link WebElement#clear WebElement.clear()},
     * {@link WebElement#sendKeys WebElement.sendKeys(...)} .
     * Not called, if an exception is thrown.
     *
     * @param driver WebDriver
     * @param element the WebElement being used for the action
     * @param keysToSend character sequence to send to the element
     */
    void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend);

    /**
     * Called before {@link WebElement#getText()} method is being called.
     *
     * @param element - {@link WebElement} against which call is being made
     * @param driver  - instance of {@link WebDriver}
     */
    void beforeGetText(WebElement element, WebDriver driver);

    /**
     * Called right after {@link WebElement#getText()} method is being called.
     *
     * @param element - {@link WebElement} against which call is being made
     * @param driver  - instance of {@link WebDriver}
     * @param text    - {@link String} object extracted from respective {@link WebElement}
     */
    void afterGetText(WebElement element, WebDriver driver, String text);
}
