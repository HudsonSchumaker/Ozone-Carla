package br.com.schumaker.carla.io;

import java.io.File;
import java.io.FileWriter;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author hudson
 */
public class O3FileReaderTest {
    
    @Test
    public void testFileExists() throws Exception {
        // Preparation
        File tmpFile = this.createTempFile(this.mockO3File());
        
        // Test
        var tested = new O3FileReader();
        var result = tested.fileExists(tmpFile.getAbsolutePath());
        
        // Assertion
        Assert.assertTrue(result);
    }
    
    @Test
    public void testFileExistsNotExists() {
        
        
    }
    
    private File createTempFile(String content) throws Exception {
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(content);
        writer.close();
        tmpFile.deleteOnExit();
        
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
}
