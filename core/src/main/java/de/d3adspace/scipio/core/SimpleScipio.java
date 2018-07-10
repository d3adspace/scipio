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

package de.d3adspace.scipio.core;

import com.google.common.collect.Lists;
import de.d3adspace.scipio.core.description.FailureDescription;
import de.d3adspace.scipio.core.exception.ScipioException;
import de.d3adspace.scipio.core.executor.FailureReporterTask;
import de.d3adspace.scipio.core.handler.FailureHandler;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Default Scipio implementation.
 *
 * @author Nathalie0hneHerz, Felix 'SasukeKawaii' Klauke
 */
public class SimpleScipio implements Scipio {

    /**
     * Handle all pending Failures and wait for the reporter to throw them into the
     * void.
     */
    private final Queue<FailureDescription> pendingFailures;

    /**
     * The container for all failure handlers.
     */
    private final List<FailureHandler> failureHandlers = Lists.newCopyOnWriteArrayList();

    /**
     * The executor of the failure reporter.
     */
    private final ExecutorService executorService;

    /**
     * Reporter Agent for all failures.
     */
    private final FailureReporterTask reporter;

    /**
     * Create a new scipion instance.
     */
    SimpleScipio() {
        this.pendingFailures = new ConcurrentLinkedQueue<>();
        this.executorService = Executors.newSingleThreadExecutor();
        this.reporter = new FailureReporterTask(this);

        this.runReporterTask();
    }

    /**
     * Start the failure agent.
     */
    private void runReporterTask() {
        this.executorService.execute(this.reporter);
    }

    @Override
    public void shutdown() {
        this.executorService.shutdown();
    }

    @Override
    public void handleFailure(FailureDescription failureDescription) {
        if (this.executorService.isShutdown()) {
            throw new ScipioException("Cant handle a failure when I was already stopped.");
        }

        this.pendingFailures.offer(failureDescription);

        synchronized (reporter) {
            this.reporter.notify();
        }
    }

    @Override
    public void addFailureHandler(FailureHandler failureHandler) {
        if (this.executorService.isShutdown()) {
            throw new ScipioException("Cant add a handler when I was already stopped.");
        }

        failureHandlers.add(failureHandler);
    }

    @Override
    public void removeFailureHandler(FailureHandler failureHandler) {
        failureHandlers.remove(failureHandler);
    }

    /**
     * Get the queue of all waiting failures.
     *
     * @return The failures.
     */
    public Queue<FailureDescription> getPendingFailures() {
        return pendingFailures;
    }

    /**
     * Get all failure handlers.
     *
     * @return The failure handlers.
     */
    public List<FailureHandler> getFailureHandlers() {
        return failureHandlers;
    }
}
