package br.com.schumaker.carla.files;

import br.com.schumaker.carla.test.O3TestHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class O3FileBuilderTest {
    
    @Test
    public void testBuild() throws Exception {
        // Preparation
        var tmpFile = O3TestHelper.createTempFileO3();
        
        // Test
        var tested = new O3FileBuilder();
        var result = tested.build(tmpFile.getAbsolutePath());
        
        // Assertions
        assertEquals("f: main() {", result.getLines().get(4).getData());
        assertEquals(5, result.getLines().get(4).getOriginalNumber().intValue());
        assertTrue(result.getLines().get(4).isFunctionHeader());
    }
    
    @Test(expected = RuntimeException.class)
    public void testBuildException() throws Exception {
        // Preparation
        var tmpFile = O3TestHelper.createTempFileO3(this.mockO3FileWithoutMainFunction());
        
        var tested = new O3FileBuilder();
        // Will fail 
        var result = tested.build(tmpFile.getAbsolutePath());
        assertEquals("f: main() {", result.getLines().get(4).getData());
        assertEquals(5, result.getLines().get(4).getOriginalNumber().intValue());
        assertTrue(result.getLines().get(4).isFunctionHeader());
    }
    
    private String mockO3FileWithoutMainFunction() {
        return "; primeiro programa\n"
                + "; autor: Hudson Schumaker\n"
                + "; data : 2020-07-31\n"
                + "\n"
                + "  v: text = \"Hello World\"\n"
                + "  print(text)\n"
                + "}";
    }
}
