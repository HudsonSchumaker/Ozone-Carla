package br.com.schumaker.carla.io.impl;

import br.com.schumaker.carla.test.TestHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals; 

/**
 * @author Hudson Schumaker
 */
public class RawSourceFileCheckerTest {

    @Test
    public void testRemoveBlankLines() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFileO3();
        var file = new SourceFileBuilder().build(tmpFile.getAbsolutePath());

        // Test
        var tested = new RawSourceFileChecker();
        tested.removeBlankLines(file);

        // Assertion
        assertEquals(7, file.getLines().size());
    }

    @Test
    public void testRemoveComments() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFileO3();
        var file = new SourceFileBuilder().build(tmpFile.getAbsolutePath());

        // Test
        var tested = new RawSourceFileChecker();
        tested.removeComments(file);

        // Assertion
        assertEquals(5, file.getLines().size());
    }

    @Test
    public void testSetInternalLineNumbers() throws Exception {
        // Preparation
        var file = TestHelper.createO3File();

        // Test
        var tested = new RawSourceFileChecker();
        tested.removeComments(file);
        tested.removeBlankLines(file);
        tested.setInternalLineNumbers(file);

        // Assertion
        assertEquals(4, file.getLines().size());
        assertEquals(0, file.getLines().get(0).getInternalNumber().intValue());
    }
}
