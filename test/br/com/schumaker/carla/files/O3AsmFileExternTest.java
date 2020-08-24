package br.com.schumaker.carla.files;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class O3AsmFileExternTest {
    
    @Test
    public void testAllO3Lib() throws Exception {
        // Preparation
        var printStr = "extern _o3prtStr";
        var upperCase = "extern _o3upperCase";
        var tested = new O3AsmFileExtern();
        
        // Test
        tested.addAllO3Lib();
        
        // Assertion(s)
        Assert.assertTrue(tested.getExternLines().contains(printStr));
        Assert.assertTrue(tested.getExternLines().contains(upperCase));        
    }
}
