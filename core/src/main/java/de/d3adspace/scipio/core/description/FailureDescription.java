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

import java.util.Map;

/**
 * Representing the description of a failure occoured in any sort of system managed by the
 * scipio containing application.
 * <p>
 * Each failure can have metadata of string key - value pairs. In this meta data store you
 * can provide useful information about the error. Example:
 * <p>
 * If you have an error like node-01.game-server-daemon.lowmemory you could append the amount
 * of free and allocated memory to make more detailed error reporting and presentation possible.
 * You can even append a little history with a detailed analysis.
 *
 * @author Felix 'SasukeKawaii' Klauke, Nathalie0hneHerz
 */
public interface FailureDescription {

    /**
     * All error should contain an unique identifier in the format of
     * <p>
     * {system}.{application}.{failure}
     * <p>
     * By this Id you can find out where exactly the failure happened. For example this could
     * look like:
     * <p>
     * node-01.game-server-daemon.notenoughmemory
     *
     * @return The unique Identifier
     */
    String getErrorId();

    /**
     * Get the system the failure occured in.
     *
     * @return The system.
     */
    String getSystem();

    /**
     * Get the application the failure occured in.
     *
     * @return The application
     */
    String getApplication();

    /**
     * Get the failure.
     *
     * @return The failure.
     */
    String getFailure();

    /**
     * Get the Priority of a failure.
     *
     * @return The priority.
     */
    Priority getPriority();

    /**
     * Gets the meta data storage for the failure.
     *
     * @return The metadata store.
     */
    Map<String, String> getMetadata();

    /**
     * When did the failure occur?
     *
     * @return The timestamp.
     */
    long getTimestamp();
}
