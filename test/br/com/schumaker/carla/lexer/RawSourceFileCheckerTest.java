package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileBuilder;
import java.io.File;
import java.io.FileWriter;
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
        File tmpFile = this.createTempFile(this.mockO3File());

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
        File tmpFile = this.createTempFile(this.mockO3File());

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
        File tmpFile = this.createTempFile(this.mockO3File());
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        var tested = new RawSourceFileChecker();
        tested.removeComments(file);
        tested.removeBlankLines(file);

        // Test
        tested.setInternalLineNumbers(file);
        
        // Assertion
        assertEquals(4, file.getLines().size());
        assertEquals(0, file.getLines().get(0).getInternalNumber().intValue());
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