package br.com.schumaker.carla.test;

import br.com.schumaker.carla.files.O3File;
import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.lexer.RawSourceFileChecker;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author schumaker
 */
public final class TestHelper {
    private TestHelper() {}
    
    public static O3File createO3File() throws Exception {
        File tmpFile = createTempFile(mockO3File());
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        var preChecker = new RawSourceFileChecker();
        preChecker.startCheck(file);
        
        return file;
    }
    
    public static File createTempFile() throws Exception {
        return createTempFile(mockO3File());
    }
    
    public static File createTempFile(String content) throws Exception {
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(content);
        writer.close();
        
        return tmpFile;
    }
    
    public static String mockO3File() {
        return "; primeiro programa\n"
                + "; autor: Hudson Schumaker\n"
                + "; data : 2020-07-31\n"
                + "\n"
                + "f: main() {\n"
                + "  v: text = \"Hello World\"\n"
                + "  print(text)\n"
                + "}";
    }
    
}
