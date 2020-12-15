package br.com.schumaker.carla.io.impl;

import br.com.schumaker.carla.exception.FileNotSupportedException;
import br.com.schumaker.carla.test.TestHelper;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * @author Hudson Schumaker
 */
public class SourceFileReaderTest {

    @Test
    public void testRead() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFileO3();

        // Test
        var tested = new SourceFileReader();
        var result = tested.read(tmpFile.getAbsolutePath());

        // Assertion
        assertEquals("f: main() {", result.get(4));
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadFail() throws Exception {
        // Preparation
        var fakeFile = new File("/hh/hhh");

        // Test
        var tested = new SourceFileReader();

        // Will Fail
        var result = tested.read(fakeFile.getAbsolutePath());
    }

    @Test(expected = FileNotSupportedException.class)
    public void testReadWrongFileType() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFile(".cpp");

        // Test
        var tested = new SourceFileReader();
        var result = tested.read(tmpFile.getAbsolutePath());

        // Assertion
        assertEquals("f: main() {", result.get(4));
    }
}
