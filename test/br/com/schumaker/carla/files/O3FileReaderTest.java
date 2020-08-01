package br.com.schumaker.carla.files;

import br.com.schumaker.carla.io.O3FileReader;
import java.io.File;
import java.io.FileWriter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author schumaker
 */
public class O3FileReaderTest {
    
    @Test
    public void testRead() throws Exception {
        
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
 
        var tested = new O3FileReader();
        var result = tested.read(tmpFile.getAbsolutePath());
        assertEquals("f: main() {", result.get(4));
        
        tmpFile.deleteOnExit();
    }
}
