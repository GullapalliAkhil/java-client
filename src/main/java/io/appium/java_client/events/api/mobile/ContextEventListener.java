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

package io.appium.java_client.events.api.mobile;

import io.appium.java_client.events.api.Listener;
import org.openqa.seleniumone.WebDriver;

public interface ContextEventListener extends Listener {

    /**
     * Called before {@link org.openqa.seleniumone.ContextAware#context(String)}.
     *
     * @param driver Webdriver
     * @param context The context that is needed to switch to.
     */
    void beforeSwitchingToContext(WebDriver driver, String context);

    /**
     * Called after {@link org.openqa.seleniumone.ContextAware#context(String)}.
     *
     * @param driver Webdriver
     * @param context The context that is needed to switch to.
     */
    void afterSwitchingToContext(WebDriver driver, String context);
}
