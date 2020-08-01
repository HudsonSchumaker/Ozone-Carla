package br.com.schumaker.carla.files;

import java.io.File;
import java.io.FileWriter;
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
        String toWrite = "; primeiro programa\n" +
                     "; autor: Hudson Schumaker\n" +
                     "; data : 2020-07-31\n" +
                     "\n" +
                     "f: main() {\n" +
                     "  @text = \"Hello World\"\n" +
                     "  print(text)\n" +
                     "}";
    
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(toWrite);
        writer.close();
        
        var tested = new O3FileBuilder();
        var result = tested.build(tmpFile.getAbsolutePath());
        assertEquals("f: main() {", result.getLines().get(4).getData());
        assertEquals(5, result.getLines().get(4).getOriginalNumber().intValue());
        assertTrue(result.getLines().get(4).isFunctionHeader());
    }
    
    @Test(expected = RuntimeException.class)
    public void testBuildException() throws Exception {
        // Preparation
        String toWrite = "; primeiro programa\n" +
                     "; autor: Hudson Schumaker\n" +
                     "; data : 2020-07-31\n" +
                     "\n" +
                     "  @text = \"Hello World\"\n" +
                     "  print(text)\n" +
                     "}";
    
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(toWrite);
        writer.close();
        
        var tested = new O3FileBuilder();
        // will fail 
        var result = tested.build(tmpFile.getAbsolutePath());
        assertEquals("f: main() {", result.getLines().get(4).getData());
        assertEquals(5, result.getLines().get(4).getOriginalNumber().intValue());
        assertTrue(result.getLines().get(4).isFunctionHeader());
    }
}
