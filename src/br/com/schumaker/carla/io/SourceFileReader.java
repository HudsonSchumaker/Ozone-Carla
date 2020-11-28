package br.com.schumaker.carla.io;

import java.util.List;

/**
 * This class is the concrete reader of O³ source files. Ex: main.o3
 *
 * @author Hudson Schumaker
 */
public class SourceFileReader implements Reader<List<String>> {

    @Override
    public boolean fileExists(String path) {
        return false;
    }

    @Override
    public boolean validExtension(String path) {
        return false;
    }

    @Override
    public List<String> read(String path) {
        return null;
    }
}
