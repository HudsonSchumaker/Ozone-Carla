package br.com.schumaker.carla.io.impl;

import br.com.schumaker.carla.exception.FunctionMainNotFoundException;
import br.com.schumaker.carla.test.TestHelper;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Hudson Schumaker
 */
public class SourceFileBuilderTest {

    @Test
    public void testBuild() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFileO3();

        // Test
        var tested = new SourceFileBuilder();
        var result = tested.build(tmpFile.getAbsolutePath());

        // Assertions
        assertEquals("f: main() {", result.getLines().get(4).getData());
        assertEquals(5, result.getLines().get(4).getOriginalNumber().intValue());
        assertTrue(result.getLines().get(4).isFunctionHeader());
    }

    @Test(expected = FunctionMainNotFoundException.class)
    public void testBuildException() throws Exception {
        // Preparation
        var tmpFile = TestHelper.createTempFileO3(this.mockO3FileWithoutMainFunction());

        // Test
        var tested = new SourceFileBuilder();

        // Will fail
        var result = tested.build(tmpFile.getAbsolutePath());
        assertEquals("f: main() {", result.getLines().get(4).getData());
        assertEquals(5, result.getLines().get(4).getOriginalNumber().intValue());
        assertTrue(result.getLines().get(4).isFunctionHeader());
    }

    @Test
    public void testCreateLines() {
        // Preparation
        var rawLine = Arrays.asList(";Hello World", "f: main {", "}");
        var tested = new SourceFileBuilder();

        // Test
        var result = tested.createLines(rawLine);

        // Assertions
        assertEquals(1, result.get(0).getOriginalNumber().intValue());
        //internal number is added later.
        assertNull(result.get(0).getInternalNumber());
        assertEquals(";Hello World", result.get(0).getData());
    }

    private String mockO3FileWithoutMainFunction() {
        return "; first program\n"
                + "; author: Albert Luiz\n"
                + "; data : 2020-07-31\n"
                + "\n"
                + "  v: text = \"Hello World\"\n"
                + "  print(text)\n"
                + "}";
    }
}
