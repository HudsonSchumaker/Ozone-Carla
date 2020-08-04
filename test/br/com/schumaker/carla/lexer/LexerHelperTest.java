package br.com.schumaker.carla.lexer;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class LexerHelperTest {
    
    @Test
    public void testIsFunctionHeader() {
        // Preparation
        var data = "f: main() {";
       
        // Test
        var result = LexerHelper.isFunctionHeader(data);
        
        // Assertion
        assertTrue(result);
    }
    
}
