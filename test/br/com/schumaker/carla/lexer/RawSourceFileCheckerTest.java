package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.test.TestHelper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author schumaker
 */
public class RawSourceFileCheckerTest {

    @Test
    public void testRemoveBlankLines() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFile();

        // Test
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        var tested = new RawSourceFileChecker();
        tested.removeBlankLines(file);

        // Assertion
        assertEquals(7, file.getLines().size());
    }

    @Test
    public void testRemoveComments() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFile();

        // Test
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        var tested = new RawSourceFileChecker();
        tested.removeComments(file);

        // Assertion
        assertEquals(5, file.getLines().size());
    }
    
    @Test
    public void testSetInternalLineNumbers() throws Exception {
        // Preparation
        var file =TestHelper.createO3File();
        
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