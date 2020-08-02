package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileBuilder;
import java.io.File;
import java.io.FileWriter;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class LexerFunctionTest {
    
    @Test
    public void testGetHeaderLines() throws Exception {
        // Preparation
        File tmpFile = this.createTempFile(this.mockO3File());
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getHeaderLines(file);
        
        // Assertion
        assertEquals("f: main() {",result.get(0).getData()); 
    }
     
    @Ignore
    @Test
    public void testSetFunctionMain() {
        
    }
            
    @Test
    public void testGetFunctionName() {
        // Preparation
        var line = "f: main() {";
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getFunctionName(line);
        
        // Assertion
        assertEquals("main", result); 
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
