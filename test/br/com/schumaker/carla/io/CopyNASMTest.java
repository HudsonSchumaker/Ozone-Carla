package br.com.schumaker.carla.io;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class CopyNASMTest {
    
    @Test
    public void testCopyNASMZipFile() throws IOException {
        // Preparation
        var tested = new CopyNASM();
        
        // Test
        tested.copyNASMZipFile();
        
        // Assertion
        var file = new File(System.getProperty("user.dir") + "/nasm.zip");
        Assert.assertTrue(file.exists());
        
        // Teardown
        file.delete();
    }
}