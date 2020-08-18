package br.com.schumaker.carla.o3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class O3FunctionTableTest {
    
    @Test
    public void testFunctionExists() throws Exception {
        // Preparation
        var tested = new O3FunctionTable();
        var print = "print";
        var camelCase = "camelCase";
        var draw = "draw";
        
        // Test - Assertion
        assertTrue(tested.functionExists(print));
        assertTrue(tested.functionExists(camelCase));
        assertFalse(tested.functionExists(draw));
    }
}
