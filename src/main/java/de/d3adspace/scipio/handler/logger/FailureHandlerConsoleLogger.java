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

package de.d3adspace.scipio.handler.logger;

import de.d3adspace.scipio.description.FailureDescription;
import de.d3adspace.scipio.handler.FailureHandler;
import java.util.logging.Logger;

/**
 * Basic handler that prints the failures to console (Logger).
 *
 * @author Felix 'SasukeKawaii' Klauke, Nathalie0hneHerz
 */
public class FailureHandlerConsoleLogger implements FailureHandler {
	
	private final Logger logger = Logger
		.getLogger(FailureHandlerConsoleLogger.class.getSimpleName());
	
	@Override
	public void handleFailure(FailureDescription failureDescription) {
		this.logger.warning(String.valueOf(failureDescription));
	}
}
