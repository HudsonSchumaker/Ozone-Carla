package br.com.schumaker.carla.io;

import br.com.schumaker.carla.test.TestHelper;
import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author hudson
 */
public class O3FileReaderTest {
    
    @Test
    public void testFileExists() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFile();
        
        // Test
        var tested = new O3FileReader();
        var result = tested.fileExists(tmpFile.getAbsolutePath());
        
        // Assertion
        Assert.assertTrue(result);
    }
    
    @Test
    public void testFileExistsNotExists() {
        // Preparation
        File tmpFile = new File("/Users/hh.h");
        
        // Test
        var tested = new O3FileReader();
        var result = tested.fileExists(tmpFile.getAbsolutePath());
        
        // Assertion
        Assert.assertFalse(result);
    }
}