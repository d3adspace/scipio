package de.d3adspace.scipio.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
class ScipioFactoryTest {

    @Test
    void testInstantiation() {
        Executable executable = ScipioFactory::new;
        assertThrows(AssertionError.class, executable);
    }

    @Test
    void testCreateScipio() {
        Scipio scipio = ScipioFactory.createScipio();

        assertNotNull(scipio, "Scipio may not be null.");
    }

    @Test
    void testCreateScipioSingleton() {
        Scipio scipio = ScipioFactory.createScipio();
        Scipio scipio1 = ScipioFactory.createScipio();

        assertEquals(scipio, scipio1, "Scipios factory should be a singleton.");
    }
}