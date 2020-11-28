package br.com.schumaker.carla.io;

import br.com.schumaker.carla.exception.FileNotSupportedException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the concrete reader of O³ source files. Ex: main.o3
 *
 * @author Hudson Schumaker
 */
public class SourceFileReader implements Reader<List<String>> {

    /**
     * Reads the lines from a .o3 source file. Reads line by line and return in raw.
     *
     * @param path Path of the source file.
     * @return Raw lines
     * @throws Exception FileNotFound or FileNotSupported.
     */
    @Override
    public List<String> read(String path) throws Exception {
        // Validations
        this.fileExists(path);
        this.validExtension(path);

        var fis = new FileInputStream(path);
        var isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        var br = new BufferedReader(isr);

        var rawLines = new ArrayList<String>();
        var rawLine = "";
        while (null != rawLine) {
            rawLine = br.readLine();
            if (null != rawLine) {
                rawLines.add(rawLine);
            }
        }
        br.close();
        return rawLines;
    }

    private void fileExists(String path) throws FileNotFoundException {
        if (!FileUtils.fileExists(path)) {
            throw new FileNotFoundException();
        }
    }

    private void validExtension(String path) {
        if (!O3SourceFile.EXT.equals(FileUtils.getFileExtension(path))) {
            throw new FileNotSupportedException();
        }
    }
}
