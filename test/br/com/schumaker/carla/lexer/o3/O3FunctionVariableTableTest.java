package br.com.schumaker.carla.lexer.o3;

import java.util.HashSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class O3FunctionVariableTableTest {
    
    @Test
    public void testVaribleIsDeclared() {
        // Preparation
        var varX = new O3Variable("axisX", "main_axisX", null);
        var varY = new O3Variable("axisY", "main_axisY", null);
        var varZ = new O3Variable("axisZ", "main_axisZ", null);
        var funcVars = new HashSet<O3Variable>();
        funcVars.add(varZ);
        funcVars.add(varY);
        funcVars.add(varX);
        
        // Test
        var tested = new O3FunctionVariableTable(funcVars);
        
        // Assertion
        assertTrue(tested.varibleIsDeclared("axisZ"));
        assertFalse(tested.varibleIsDeclared("pi"));
    }
}
