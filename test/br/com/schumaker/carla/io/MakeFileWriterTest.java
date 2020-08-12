package br.com.schumaker.carla.io;

import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class MakeFileWriterTest {

    @Test
    public void testWrite() {
        // Preparation
        var tested = new MakeFileWriter();

        // Test
        tested.write("hello");

        // Assertion
        var file = new File(System.getProperty("user.dir") + "/Makefile");
        Assert.assertTrue(file.exists());

        // Teardown
        file.delete();
    }
}
