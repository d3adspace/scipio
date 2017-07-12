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

package de.d3adspace.scipio.core.meta;

/**
 * A container as a metadata store to prohibit direct access to the meta data and reduce the
 * access options down to basic CRUD operations.
 *
 * @author Nathalie0hneHerz
 */
public interface MetadataContainer {

    /**
     * Store a new metadata entry.
     *
     * @param key   The key.
     * @param value The value.
     */
    void addMetadataEntry(String key, String value);

    /**
     * Remove a metadata entry.
     *
     * @param key The key.
     */
    void removeMetadataEntry(String key);

    /**
     * Check if there is a metadata entry for the given key.
     *
     * @param key The key.
     * @return If there is an entry.
     */
    boolean containsMetadataEntry(String key);

    /**
     * Get a metadata entry by its key.
     *
     * @param key The key.
     * @return The value.
     */
    String getMetadataValue(String key);
}
