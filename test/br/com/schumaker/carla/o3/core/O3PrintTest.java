package br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.exception.ArgumentTypeNotSupportedException;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class O3PrintTest {
    
    @Test
    public void testGetCoreNameByType() throws Exception {
        // Preparation
        var valueStr = "o3prtStr";
        var valueInt = "o3prtInt";
        var tested = new O3Print();
        
        // Test
        var resultStr = tested.getCoreNameByType(O3VariableType.STRING);
        var resultInt = tested.getCoreNameByType(O3VariableType.INT);
        
        // Assertion(s)
        Assert.assertEquals(valueStr, resultStr);
        Assert.assertEquals(valueInt, resultInt);
    }
    
    @Test(expected = ArgumentTypeNotSupportedException.class)
    public void testGetCoreNameByTypeException() throws Exception {
         // Preparation
        var valueStr = "o3prtStr";
        var valueInt = "o3prtInt";
        var tested = new O3Print();
        
        // Test
        var resultStr = tested.getCoreNameByType(O3VariableType.STRING);
        var resultInt = tested.getCoreNameByType(O3VariableType.INT);
        var resultByte = tested.getCoreNameByType(O3VariableType.BYTE);
        
        // Will fail
        Assert.assertEquals(valueStr, resultStr);
        Assert.assertEquals(valueInt, resultInt);
    } 
}
