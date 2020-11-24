package br.com.schumaker.carla.test;

import br.com.schumaker.carla.files.O3File;
import br.com.schumaker.carla.files.O3FileBuilder;
import br.com.schumaker.carla.lexer.RawSourceFileChecker;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Hudson Schumaker
 */
public final class O3TestHelper {
    private O3TestHelper() {}
    
    public static O3File createO3File() throws Exception {
        File tmpFile = createTempFileO3(mockO3File());
        var builder = new O3FileBuilder();
        var file = builder.build(tmpFile.getAbsolutePath());
        var preChecker = new RawSourceFileChecker();
        preChecker.startCheck(file);
        
        return file;
    }
    
    public static File createTempFileO3() throws Exception {
        return createTempFileO3(mockO3File());
    }
    
    public static File createTempFileO3(String content) throws Exception {
        File tmpFile = File.createTempFile("test", ".o3");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(content);
        writer.close();
        tmpFile.deleteOnExit();
        
        return tmpFile;
    }
    
    public static File createTempFile() throws Exception {
        File tmpFile = File.createTempFile("test", ".ooo");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(mockO3File());
        writer.close();
        tmpFile.deleteOnExit();
        
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
