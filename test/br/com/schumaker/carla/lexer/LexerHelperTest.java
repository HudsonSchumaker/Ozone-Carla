package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.test.O3TestHelper;
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
    
    @Test
    public void testIsConditionalStatement() {
        // Preparation
        var data = "if (1 > x) {";
       
        // Test
        var result = LexerHelper.isConditionalStatement(data);
        
        // Assertion
        assertTrue(result);
    }
    
    @Test
    public void testIsLoopStatement() {
        // Preparation
        var data = "while( x > 10) {";
       
        // Test
        var result = LexerHelper.isLoopStatement(data);
        
        // Assertion
        assertTrue(result);
    }
    
    @Test
    public void testIsVariableDeclaration() {
        // Preparation
        var data = "v: number = 56";
       
        // Test
        var result = LexerHelper.isVariableDeclaration(data);
        
        // Assertion
        assertTrue(result);
    }
    
    @Test
    public void testContainsFunctionMain() throws Exception {
        // Preparation
        var file  = O3TestHelper.createO3File();
       
        // Test
        var result = LexerHelper.containsFunctionMain(file);
        
        // Assertion
        assertTrue(result);
    }
}
