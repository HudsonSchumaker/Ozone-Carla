package br.com.schumaker.carla.io;

import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class MakeFileWriterTest {

    @Test
    public void testWrite() {
        // Preparation
        var atomName = "hello";
        Workspace.createWorkspace(atomName);
        var tested = new MakeFileWriter();

        // Test
        tested.write(atomName);

        // Assertion(s)
        var file = new File(System.getProperty("user.dir") + "/" + atomName + "/Makefile");
        Assert.assertTrue(file.exists());

        // Teardown
        file.delete();
        var dir = new File(System.getProperty("user.dir") + "/" + atomName);
        dir.delete();
    }
}
