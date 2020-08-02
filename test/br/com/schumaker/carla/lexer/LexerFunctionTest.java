package br.com.schumaker.carla.lexer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class LexerFunctionTest {
    
    @Test
    public void testGetFunctionName() {
        // Preparation
        var line = "f: main() {";
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getFunctionName(line);
        // Assertion
        assertEquals("main", result);
        
    }
}
