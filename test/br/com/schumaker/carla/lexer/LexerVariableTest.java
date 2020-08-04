package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.o3.O3VariableType;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class LexerVariableTest {
        
    @Test
    public void testGetVariables() {
        // Preparation
        var fileLineString = new O3FileLine(" v: text = \"Hello World!\"", 4);
        var fileLineInteger = new O3FileLine(" v: number = 5", 5);
        var fileLines = Arrays.asList(fileLineString, fileLineInteger);
        var funcName = "main";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariables(funcName, fileLines);
        
        // Assertions
        assertEquals("text", result.get(0).getName());
        assertEquals("main_text:", result.get(0).getInternalName());
        assertEquals(O3VariableType.STRING, result.get(0).getTypeValue().getType());
        assertEquals("\"Hello World!\"", result.get(0).getTypeValue().getValue());
        
        assertEquals("number", result.get(1).getName());
        assertEquals("main_number:", result.get(1).getInternalName());
        assertEquals(O3VariableType.INT, result.get(1).getTypeValue().getType());
        assertEquals(5, result.get(1).getTypeValue().getValue());
    }
    
    @Test
    public void testGetVariableString() {
        // Preparation
        var fileLine = new O3FileLine("v: text = \"Hello World!\"", 4);
        var funcName = "main";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariable(funcName, fileLine);
        
        // Assertions
        assertEquals("text", result.getName());
        assertEquals("main_text:", result.getInternalName());
        assertEquals(O3VariableType.STRING, result.getTypeValue().getType());
        assertEquals("\"Hello World!\"", result.getTypeValue().getValue());
    }
    
    @Test
    public void testGetVariableInteger() {
        // Preparation
        var fileLine = new O3FileLine("v: number = 5", 4);
        var funcName = "main";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariable(funcName, fileLine);
        
        // Assertions
        assertEquals("number", result.getName());
        assertEquals("main_number:", result.getInternalName());
        assertEquals(O3VariableType.INT, result.getTypeValue().getType());
        assertEquals(5, result.getTypeValue().getValue());
    }
    
    @Test
    public void testGetVariableBoolean() {
        // Preparation
        var fileLine = new O3FileLine("v: isX86 = true", 4);
        var funcName = "main";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariable(funcName, fileLine);
        
        // Assertions
        assertEquals("isX86", result.getName());
        assertEquals("main_isX86:", result.getInternalName());
        assertEquals(O3VariableType.BOOL, result.getTypeValue().getType());
        assertEquals(Boolean.TRUE, result.getTypeValue().getValue());
    }
    
    @Test
    public void testGetVariableFloat() {
        // Preparation
        var fileLine = new O3FileLine("v: pi = 3.14f", 4);
        var funcName = "main";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariable(funcName, fileLine);
        
        // Assertions
        assertEquals("pi", result.getName());
        assertEquals("main_pi:", result.getInternalName());
        assertEquals(O3VariableType.FLOAT, result.getTypeValue().getType());
        assertEquals(3.14f, result.getTypeValue().getValue());
    }
     
    @Test
    public void testGetTypeString() {
        // Preparation
        var data = "v: text = \"Hello World!\"";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getType(data);
        
        // Assertion
        assertEquals(O3VariableType.STRING, result);
    }
    
    @Test
    public void testGetTypeInteger() {
        // Preparation
        var data = "v: number = 5";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getType(data);
        
        // Assertion
        assertEquals(O3VariableType.INT, result);
    }
    
    @Test
    public void testGetTypeFloat() {
        // Preparation
        var data = "v: pi = 3.14f";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getType(data);
        
        // Assertion
        assertEquals(O3VariableType.FLOAT, result);
    }
    
    @Test
    public void testGetTypeBoolean() {
        // Preparation
        var data = "v: isX86 = true";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getType(data);
        
        // Assertion
        assertEquals(O3VariableType.BOOL, result);
    }

    @Test
    public void testGetValueString() {
        // Preparation
        var data = "v: text = \"Hello World!\"";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getValueString(data);
        
        // Assertions
        assertEquals("\"Hello World!\"", result);
        assertEquals(String.class, result.getClass());
    }
    
    @Test
    public void testGetValueInteger() {
        // Preparation
        var data = "v: number = 5";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getValueInteger(data);
        
        // Assertions
        assertEquals(5, result.intValue());
        assertEquals(Integer.class, result.getClass());
    }
    
    @Test
    public void testGetValueBoolean() {
        // Preparation
        var data = "v: isX86 = true";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getValueBoolean(data);
        
        // Assertions
        assertTrue(result);
        assertEquals(Boolean.class, result.getClass());
    }
    
    @Test
    public void testGetValueFloat() {
        // Preparation
        var data = "v: pi = 3.14f";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getValueFloat(data);
        
        // Assertions
        assertEquals(3.14, result, 0.1f);
        assertEquals(Float.class, result.getClass());
    }
    
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
        var data = "v:number=5";
        
        // Test
        var tested = new LexerVariable();
        var result = tested.getVariableName(data);
        
        // Assertion
        assertEquals("number", result); 
    }
}
