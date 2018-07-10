/*
 * Copyright (c) 2017 D3adspace
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.d3adspace.scipio.core.description;

import com.google.common.collect.Maps;
import de.d3adspace.scipio.core.priority.Priority;

import java.util.Map;

/**
 * @author Nathalie0hneHerz
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class SimpleFailureDescription implements FailureDescription {

    private final Map<String, String> metadata = Maps.newHashMap();
    private final String system;
    private final String application;
    private final String failure;
    private final Priority priority;
    private final long timestamp;

    SimpleFailureDescription(String system, String application, String failure,
                             Priority priority, long timestamp) {
        this.system = system;
        this.application = application;
        this.failure = failure;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    @Override
    public String getErrorId() {
        return String.format("%s.%s.%s", system, application, failure);
    }

    @Override
    public String getSystem() {
        return system;
    }

    @Override
    public String getApplication() {
        return application;
    }

    @Override
    public String getFailure() {
        return failure;
    }

    @Override
    public Priority getPriority() {
        return this.priority;
    }

    @Override
    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}
