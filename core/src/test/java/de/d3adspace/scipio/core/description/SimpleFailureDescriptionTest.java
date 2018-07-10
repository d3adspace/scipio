package de.d3adspace.scipio.core.description;

import de.d3adspace.scipio.core.priority.Priority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
class SimpleFailureDescriptionTest {

    private static final String TEST_SYSTEM = "testSystem";
    private static final String TEST_APPLICATION = "testApplication";
    private static final String TEST_FAILURE = "testFailure";
    private static final Priority TEST_PRIORITY = Priority.CRITICAL;
    private static final long TEST_TIMESTAMP = System.currentTimeMillis();

    private static final String TEST_ERROR_ID = TEST_SYSTEM + "." + TEST_APPLICATION + "." + TEST_FAILURE;

    private FailureDescription failureDescription;

    @BeforeEach
    void setUp() {
        failureDescription = new SimpleFailureDescription(TEST_SYSTEM, TEST_APPLICATION, TEST_FAILURE, TEST_PRIORITY, TEST_TIMESTAMP);
    }

    @Test
    void testGetErrorId() {
        assertEquals(TEST_ERROR_ID, failureDescription.getErrorId(), "Error Id differs.");
    }

    @Test
    void testGetSystem() {
        assertEquals(TEST_SYSTEM, failureDescription.getSystem(), "System differs.");
    }

    @Test
    void testGetApplication() {
        assertEquals(TEST_APPLICATION, failureDescription.getApplication(), "Application differs.");
    }

    @Test
    void testGetFailure() {
        assertEquals(TEST_FAILURE, failureDescription.getFailure(), "Failure differs.");
    }

    @Test
    void getPriority() {
        assertNotNull(failureDescription.getPriority(), "Proprity may not be null.");
        assertEquals(TEST_PRIORITY.ordinal(), failureDescription.getPriority().ordinal(), "Priority differs.");
    }

    @Test
    void getMetadata() {
        assertNotNull(failureDescription.getMetadata(), "Meta data may not be null.");
        assertEquals(0, failureDescription.getMetadata().size(), "Meta data size should be 0 by default.");
    }

    @Test
    void getTimestamp() {
        assertEquals(TEST_TIMESTAMP, failureDescription.getTimestamp(), "Time stamp differs.");
    }
}