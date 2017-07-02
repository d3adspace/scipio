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

package de.d3adspace.scipio.provider;

import de.d3adspace.scipio.priority.Priority;

/**
 * Offer the possibility to create an enum or another sort of constant provider and create
 * a failure description from it.
 *
 * @author Nathalie0hneHerz, Felix 'SasukeKawaii' Klauke
 */
public interface FailureProvider {
	
	/**
	 * Get the system the failure occured on.
	 *
	 * @return The system.
	 */
	String getSystem();
	
	/**
	 * Get the application the error occured in.
	 *
	 * @return The application.
	 */
	String getApplication();
	
	/**
	 * The failure that occured.
	 *
	 * @return The failure.
	 */
	String getFailure();
	
	/**
	 * The priority of the failure.
	 *
	 * @return The priority.
	 */
	Priority getPriority();
}
