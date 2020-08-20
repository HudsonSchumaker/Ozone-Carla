package br.com.schumaker.carla.o3;

import org.junit.Assert;
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
        var tested = new O3CoreFunctionTable();
        var print = "print";
        var camelCase = "camelCase";
        var draw = "draw";
        
        // Test - Assertions
        assertTrue(tested.functionExists(print));
        assertTrue(tested.functionExists(camelCase));
        assertFalse(tested.functionExists(draw));
    }
    
    @Test
    public void testGetLibNameByFunctionName() throws Exception {
        // Preparation
        var tested = new O3CoreFunctionTable();
        
        // Test - Assertions
        Assert.assertEquals(O3CoreLibrary.PRINT_O, tested.getLibNameByFunctionName(O3CoreFunctionTable.PRT_PRINT));
        Assert.assertEquals(O3CoreLibrary.STRINGS_O, tested.getLibNameByFunctionName(O3CoreFunctionTable.STR_CAMEL_CASE));
        Assert.assertEquals("", tested.getLibNameByFunctionName("draw"));
    }
}