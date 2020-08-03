package br.com.schumaker.carla.lexer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class LexerVariableTest {
    
    @Test
    public void testGetVariableNameConventionalWay() {
        // Preparation
        var line = "v: number = 5";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariableName(line);
        
        // Assertion
        assertEquals("number", result); 
    }
    
    @Test
    public void testGetVariableNotConventional() {
        // Preparation
        var line = "v:number=5";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariableName(line);
        
        // Assertion
        assertEquals("number", result); 
    }
}
