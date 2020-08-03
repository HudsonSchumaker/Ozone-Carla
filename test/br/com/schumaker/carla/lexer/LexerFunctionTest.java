package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.files.O3FileLine;
import java.io.File;
import java.io.FileWriter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author schumaker
 */
public class LexerFunctionTest {
    
    @Test
    public void testGetFunctions() throws Exception {
        // Preparation
        File tmpFile = this.createTempFile(this.mockO3File());
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        var preChecker = new RawSourceFileChecker();
        preChecker.startCheck(file);
        
        // Test
        var tested = new LexerFunction();
        var result = tested.getFunctions(file);
        
        // Assertions
        assertEquals("main", result.get(0).getName());
        assertTrue(result.get(0).isMain());
    }
    
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
     
    
    public boolean isMainFunction(O3FileLine headerLine) {
        return headerLine.getData().contains("f: main()");
    }
    
    @Test
    public void testIsMainFunction() {
         // Preparation
        var line = new O3FileLine("f: main() {", 0);
        
        // Test
        var tested = new LexerFunction();
        var result = tested.isMainFunction(line);
        
        // Assertion
        assertTrue(result); 
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
