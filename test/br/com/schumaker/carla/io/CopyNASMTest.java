package br.com.schumaker.carla.io;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class CopyNASMTest {
    
    @Test
    public void testCopyNASMZipFile() throws IOException {
        // Preparation
        var atomName = "/hello";
        Workspace.createWorkspace(atomName);
        var tested = new CopyNASM();
        
        // Test
        tested.copyNASMZipFile(atomName);
        
        // Assertion(s)
        var file = new File(System.getProperty("user.dir") + atomName + "/nasm.zip");
        Assert.assertTrue(file.exists());
        
        // Teardown
        file.delete();
        var dir = new File(System.getProperty("user.dir") + atomName);
        dir.delete();
    }
}