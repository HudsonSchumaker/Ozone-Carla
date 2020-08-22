package br.com.schumaker.carla.files;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class O3AsmFileHeaderTest {
    
    @Test
    public void testGenerateHeader() {
        // Preparation
        var tested = new O3AsmFileHeader();
        // Test
        var result = tested.generateHeader();
        
        // Assertion(s)
        Assert.assertTrue(result.contains(O3AsmFileHeader.HEADER));
    }
}
