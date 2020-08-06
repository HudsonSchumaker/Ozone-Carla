package br.com.schumaker.carla.lexer.o3;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class O3VariableTypeValueTest {
    
   @Test
   public void testOf() {
       // Preparation
       var type = O3VariableType.BOOL;
       
       // Test
       var result = O3VariableTypeValue.of(type, type.BOOL.getDefaultValue());
       
       // Assertion
       Assert.assertEquals(type, result.getType());
       Assert.assertEquals("false", result.getValue());       
   }   
}