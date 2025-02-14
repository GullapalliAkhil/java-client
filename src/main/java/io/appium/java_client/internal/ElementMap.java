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

package io.appium.java_client.internal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.seleniumone.remote.RemoteWebElement;

import java.util.Map;
import java.util.Optional;

public enum ElementMap {
    ANDROID_UIAUTOMATOR2(AutomationName.ANDROID_UIAUTOMATOR2.toLowerCase(), AndroidElement.class),
    SELENDROID(AutomationName.SELENDROID.toLowerCase(), AndroidElement.class),
    IOS_XCUI_TEST(AutomationName.IOS_XCUI_TEST.toLowerCase(), IOSElement.class),
    ANDROID_UI_AUTOMATOR(MobilePlatform.ANDROID.toLowerCase(), AndroidElement.class),
    IOS_UI_AUTOMATION(MobilePlatform.IOS.toLowerCase(), IOSElement.class),
    WINDOWS(MobilePlatform.WINDOWS, WindowsElement.class);


    private static final Map<String, ElementMap> mobileElementMap;

    static {
        ImmutableMap.Builder<String, ElementMap> builder = ImmutableMap.builder();
        for (ElementMap e:values()) {
            builder.put(e.getPlatformOrAutomation(), e);
        }
        mobileElementMap = builder.build();
    }



    private final String platformOrAutomation;
    private final Class<? extends RemoteWebElement> elementClass;

    private ElementMap(String platformOrAutomation, Class<? extends MobileElement> elementClass) {
        this.platformOrAutomation = platformOrAutomation;
        this.elementClass = elementClass;
    }

    public String getPlatformOrAutomation() {
        return platformOrAutomation;
    }

    public Class<? extends RemoteWebElement> getElementClass() {
        return elementClass;
    }

    /**
     * Gets element class by {@code platform} and mobile {@code automation} type.
     *
     * @param platform is the mobile platform. See {@link MobilePlatform}.
     * @param automation is the mobile automation type. See {@link AutomationName}
     * @return subclass of {@link RemoteWebElement} that convenient to current session details.
     */
    public static Class<? extends RemoteWebElement> getElementClass(String platform, String automation) {
        if (isBlank(platform) && isBlank(automation)) {
            return RemoteWebElement.class;
        }
        ElementMap element = Optional.ofNullable(mobileElementMap.get(
                String.valueOf(platform).toLowerCase().trim()))
                .orElseGet(() -> mobileElementMap
                        .get(String.valueOf(automation).toLowerCase().trim()));
        if (element == null) {
            return RemoteWebElement.class;
        }
        return element.getElementClass();
    }
}
