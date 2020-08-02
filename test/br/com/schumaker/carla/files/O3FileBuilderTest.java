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
        File tmpFile = this.createTempFile(this.mockO3File());
        
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
        File tmpFile = this.createTempFile(this.mockO3FileWithoutMainFunction());
        
        var tested = new O3FileBuilder();
        // Will fail 
        var result = tested.build(tmpFile.getAbsolutePath());
        assertEquals("f: main() {", result.getLines().get(4).getData());
        assertEquals(5, result.getLines().get(4).getOriginalNumber().intValue());
        assertTrue(result.getLines().get(4).isFunctionHeader());
    }
    
    private File createTempFile(String content) throws Exception {
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(content);
        writer.close();
        
        return tmpFile;
    }

    private String mockO3File() {
        return "; primeiro programa\n"
                + "; autor: Hudson Schumaker\n"
                + "; data : 2020-07-31\n"
                + "\n"
                + "f: main() {\n"
                + "  @text = \"Hello World\"\n"
                + "  print(text)\n"
                + "}";
    }
    
    private String mockO3FileWithoutMainFunction() {
        return "; primeiro programa\n"
                + "; autor: Hudson Schumaker\n"
                + "; data : 2020-07-31\n"
                + "\n"
                + "  @text = \"Hello World\"\n"
                + "  print(text)\n"
                + "}";
    }
}
