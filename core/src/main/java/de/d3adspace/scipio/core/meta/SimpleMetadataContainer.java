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

import java.util.HashMap;
import java.util.Map;

/**
 * Default meta data store implementation.
 *
 * @author Nathalie0hneHerz
 */
public class SimpleMetadataContainer implements MetadataContainer {

    /**
     * The underlying map.
     */
    private final Map<String, String> metadataStore;

    /**
     * Create a meta data store from an already known map of entries.
     *
     * @param metadataStore The entries.
     */
    SimpleMetadataContainer(Map<String, String> metadataStore) {
        this.metadataStore = metadataStore;
    }

    /**
     * Create an empty metadata container.
     */
    SimpleMetadataContainer() {
        this(new HashMap<>());
    }

    @Override
    public void addMetadataEntry(String key, String value) {
        this.metadataStore.put(key, value);
    }

    @Override
    public void removeMetadataEntry(String key) {
        this.metadataStore.remove(key);
    }

    @Override
    public boolean containsMetadataEntry(String key) {
        return this.metadataStore.containsKey(key);
    }

    @Override
    public String getMetadataValue(String key) {
        return metadataStore.get(key);
    }

    @Override
    public String toString() {
        return "SimpleMetadataContainer{" +
                "metadataStore=" + metadataStore +
                '}';
    }
}
