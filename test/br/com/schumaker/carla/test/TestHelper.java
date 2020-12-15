package br.com.schumaker.carla.test;


import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.RawSourceFileChecker;
import br.com.schumaker.carla.io.impl.SourceFileBuilder;

import java.io.File;
import java.io.FileWriter;

/**
 * @author Hudson Schumaker
 */
public final class TestHelper {
    public static O3File createO3File() throws Exception {
        File tmpFile = createTempFileO3(mockO3File());
        var file = new SourceFileBuilder().build(tmpFile.getAbsolutePath());
        new RawSourceFileChecker().doCheck(file);
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
        File tmpFile = File.createTempFile("test", ".o3");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(mockO3File());
        writer.close();
        tmpFile.deleteOnExit();

        return tmpFile;
    }

    public static File createTempFile(String ext) throws Exception {
        File tmpFile = File.createTempFile("test", ext);
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
