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

package io.appium.java_client;

import com.google.common.collect.ImmutableMap;

import org.openqa.seleniumone.By;
import org.openqa.seleniumone.Dimension;
import org.openqa.seleniumone.Point;
import org.openqa.seleniumone.remote.FileDetector;

import java.util.List;

@SuppressWarnings({"unchecked"})
public abstract class MobileElement
    extends DefaultGenericMobileElement<MobileElement> {

    protected FileDetector fileDetector;

    /**
     * Method returns central coordinates of an element.
     * @return The instance of the {@link org.openqa.seleniumone.Point}
     */
    public Point getCenter() {
        Point upperLeft = this.getLocation();
        Dimension dimensions = this.getSize();
        return new Point(upperLeft.getX() + dimensions.getWidth() / 2,
            upperLeft.getY() + dimensions.getHeight() / 2);
    }

    @Override public List<MobileElement> findElements(By by) {
        return super.findElements(by);
    }

    @Override public List<MobileElement> findElements(String by, String using) {
        return super.findElements(by, using);
    }

    @Override public List<MobileElement> findElementsById(String id) {
        return super.findElementsById(id);
    }

    public List<MobileElement> findElementsByLinkText(String using) {
        return super.findElementsByLinkText(using);
    }

    public List<MobileElement> findElementsByPartialLinkText(String using) {
        return super.findElementsByPartialLinkText(using);
    }

    public List<MobileElement> findElementsByTagName(String using) {
        return super.findElementsByTagName(using);
    }

    public List<MobileElement> findElementsByName(String using) {
        return super.findElementsByName(using);
    }

    public List<MobileElement> findElementsByClassName(String using) {
        return super.findElementsByClassName(using);
    }

    public List<MobileElement> findElementsByCssSelector(String using) {
        return super.findElementsByCssSelector(using);
    }

    public List<MobileElement> findElementsByXPath(String using) {
        return super.findElementsByXPath(using);
    }

    @Override public List<MobileElement> findElementsByAccessibilityId(String using) {
        return super.findElementsByAccessibilityId(using);
    }

    /**
     * This method sets the new value of the attribute "value".
     *
     * @param value is the new value which should be set
     */
    public void setValue(String value) {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.put("id", id).put("value", value);
        execute(MobileCommand.SET_VALUE, builder.build());
    }
}
