package br.com.schumaker.carla.io.impl;

import br.com.schumaker.carla.exception.FileNotSupportedException;
import br.com.schumaker.carla.io.Reader;
import br.com.schumaker.carla.utils.FileUtils;

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

    @Override
    public List<String> read(String path) throws Exception {

        // Validations
        this.fileExists(path);
        this.validExtension(path);

        var fis = new FileInputStream(path);
        var isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        var bfr = new BufferedReader(isr);

        var rawLines = new ArrayList<String>();
        var rawLine = "";
        while (null != rawLine) {
            rawLine = bfr.readLine();
            if (null != rawLine) {
                rawLines.add(rawLine);
            }
        }
        bfr.close();
        return rawLines;
    }

    private void fileExists(String path) throws FileNotFoundException {
        if (!FileUtils.fileExists(path)) {
            throw new FileNotFoundException();
        }
    }

    private void validExtension(String path) {
        if (!O3File.EXT.equals(FileUtils.getFileExtension(path))) {
            throw new FileNotSupportedException();
        }
    }
}
