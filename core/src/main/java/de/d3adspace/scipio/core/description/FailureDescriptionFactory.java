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
import de.d3adspace.scipio.core.provider.FailureProvider;

/**
 * Create a description.
 *
 * @author Felix 'SasukeKawaii' Klauke
 */
public class FailureDescriptionFactory {

    /**
     * Create a new description based on a provider.
     *
     * @param failureProvider The provider.
     * @return The description.
     */
    public static FailureDescription createFailureDescription(FailureProvider failureProvider) {
        return createFailureDescription(failureProvider, System.currentTimeMillis());
    }

    /**
     * Create a new descripion based on a provider and a timestamp.
     *
     * @param failureProvider The provider.
     * @param timestamp       The timestamp.
     * @return The description.
     */
    public static FailureDescription createFailureDescription(FailureProvider failureProvider,
                                                              long timestamp) {
        return createFailureDescription(failureProvider.getSystem(),
                failureProvider.getApplication(), failureProvider.getFailure(),
                failureProvider.getPriority(), timestamp);
    }

    /**
     * Create a description based on all its data except the timestamp. Current timestamp will be used.
     *
     * @param system      The system.
     * @param application The application.
     * @param failure     The failure.
     * @param priority    The priority.
     * @return The description.
     */
    public static FailureDescription createFailureDescription(String system, String application,
                                                              String failure,
                                                              Priority priority) {

        return createFailureDescription(system, application, failure, priority,
                System.currentTimeMillis());
    }

    /**
     * Createa a description based on all its data.
     *
     * @param system      The system.
     * @param application The application.
     * @param failure     The failure.
     * @param priority    The priority.
     * @param timestamp   The timestamp-
     * @return The description.
     */
    public static FailureDescription createFailureDescription(String system, String application,
                                                              String failure,
                                                              Priority priority, long timestamp) {

        return new FailureDescriptionBuilder().setSystem(system).setApplication(application)
                .setFailure(failure).setPriority(priority).setTimestamp(timestamp)
                .createSimpleFailureDescription();
    }
}
