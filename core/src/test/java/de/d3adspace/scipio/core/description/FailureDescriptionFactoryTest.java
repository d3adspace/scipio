package de.d3adspace.scipio.core.description;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
class FailureDescriptionFactoryTest {

    @Test
    void testInstantiation() {
        Executable executable = FailureDescriptionFactory::new;
        assertThrows(AssertionError.class, executable);
    }

    @Test
    void testCreateFailureDescription() {
    }

    @Test
    void testCreateFailureDescription1() {
    }

    @Test
    void testCreateFailureDescription2() {
    }

    @Test
    void testCreateFailureDescription3() {
    }
}