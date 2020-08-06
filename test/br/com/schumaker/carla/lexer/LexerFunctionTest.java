package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.test.O3TestHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class LexerFunctionTest {
    
    @Test
    public void testGetFunctions() throws Exception {
        // Preparation
        var file = O3TestHelper.createO3File();
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getFunctions(file);
        
        // Assertions
        assertEquals("main", result.get(0).getName());
        assertTrue(result.get(0).isMain());
    }
    
    @Test
    public void testSetStatement() throws Exception {
        // Preparation
        var file = O3TestHelper.createO3File();

        var tested = new LexerFunction();
        var headerLines = tested.getHeaderLines(file);
        
        // Test
        var result = tested.setStatement(headerLines.get(0), file);
        
        // Assertions
        assertEquals("main", result.getName());
        assertTrue(result.isMain());        
    }
    
    @Test
    public void testGetHeaderLines() throws Exception {
        // Preparation
        var tmpFile = O3TestHelper.createTempFileO3();
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getHeaderLines(file);
        
        // Assertion
        assertEquals("f: main() {", result.get(0).getData()); 
    }
     
    @Test
    public void testIsMainFunction() {
         // Preparation
        var line = new O3FileLine("f: main() {", 0);
        
        // Test
        var tested = new LexerFunction();
        var result = tested.isMainFunction(line);
        
        // Assertion
        assertTrue(result); 
    }
            
    @Test
    public void testGetFunctionNameConventionalWay() {
        // Preparation
        var line = "f: main() {";
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getFunctionName(line);
        
        // Assertion
        assertEquals("main", result); 
    }
    
    @Test
    public void testGetFunctionNameNotConventionalWay() {
        // Preparation
        var line = "f:main(){";
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getFunctionName(line);
        
        // Assertion
        assertEquals("main", result); 
    }
}