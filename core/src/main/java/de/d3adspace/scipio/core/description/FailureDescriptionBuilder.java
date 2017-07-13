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

import de.d3adspace.scipio.core.priority.Priority;

/**
 * Basic Builder to create a custom failure description.
 */
public class FailureDescriptionBuilder {

    /**
     * The system the failure occured on.
     */
    private String system;

    /**
     * The application the failure occured in.
     */
    private String application;

    /**
     * The failure.
     */
    private String failure;

    /**
     * The priority of the failure.
     */
    private Priority priority;

    /**
     * The timestamp when the failure occured.
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * Set the system.
     *
     * @param system The system.
     * @return The builder.
     */
    public FailureDescriptionBuilder setSystem(String system) {
        this.system = system;
        return this;
    }

    /**
     * Set the application.
     *
     * @param application The application.
     * @return The builder.
     */
    public FailureDescriptionBuilder setApplication(String application) {
        this.application = application;
        return this;
    }

    /**
     * Set the failure.
     *
     * @param failure The failure.
     * @return The builder.
     */
    public FailureDescriptionBuilder setFailure(String failure) {
        this.failure = failure;
        return this;
    }

    /**
     * Set the priority.
     *
     * @param priority The priority.
     * @return The builder.
     */
    public FailureDescriptionBuilder setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Set the timestamp.
     *
     * @param timestamp The timestamp.
     * @return The builder.
     */
    public FailureDescriptionBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Create the description.
     *
     * @return The failure description.
     */
    public SimpleFailureDescription createSimpleFailureDescription() {
        return new SimpleFailureDescription(system, application, failure, priority, timestamp);
    }
}