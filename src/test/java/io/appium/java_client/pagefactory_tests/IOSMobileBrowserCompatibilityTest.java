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

package io.appium.java_client.pagefactory_tests;

import static java.time.Duration.ofSeconds;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.seleniumone.WebDriver;
import org.openqa.seleniumone.WebElement;
import org.openqa.seleniumone.remote.DesiredCapabilities;
import org.openqa.seleniumone.support.FindBy;
import org.openqa.seleniumone.support.FindBys;
import org.openqa.seleniumone.support.PageFactory;

import java.util.List;

public class IOSMobileBrowserCompatibilityTest {

    private WebDriver driver;
    private AppiumDriverLocalService service;

    @FindBy(name = "q")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/someId\")")
    @iOSXCUITFindBy(className = "someClass") private WebElement searchTextField;

    @AndroidFindBy(className = "someClass")
    @FindBys({@FindBy(className = "r"), @FindBy(tagName = "a")}) @iOSXCUITFindBy(className = "someClass")
    private List<WebElement> foundLinks;

    /**
     * The setting up.
     */
    @Before public void setUp() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        //sometimes environment has performance problems
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        driver = new IOSDriver<>(service.getUrl(), capabilities);
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
    }

    /**
     * finishing.
     */
    @After public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        if (service != null) {
            service.stop();
        }
    }

    @Test public void test() {
        driver.get("https://www.google.com");

        searchTextField.sendKeys("Hello");
        searchTextField.submit();
        Assert.assertNotEquals(0, foundLinks.size());
        searchTextField.clear();
        searchTextField.sendKeys("Hello, Appium!");
        searchTextField.submit();
    }

}
