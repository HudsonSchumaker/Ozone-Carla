package br.com.schumaker.carla.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Hudson Schumaker
 */
public class StringUtilsTest {

    @Test
    public void testIsBlankStringFalse() {
        // Preparation
        var value = "This is a String";

        // Test
        var result = StringUtils.isBlankString(value);

        // Assertion
        assertFalse(result);
    }

    @Test
    public void testIsBlankStringTrue() {
        // Preparation
        var value = "";

        // Test
        var result = StringUtils.isBlankString(value);

        // Assertion
        assertTrue(result);
    }

    @Test
    public void testIsBlankStringNull() {
        // Preparation
        String value = null;

        // Test
        var result = StringUtils.isBlankString(value);

        // Assertion
        assertTrue(result);
    }
}
