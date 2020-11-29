package br.com.schumaker.carla.run;

import br.com.schumaker.carla.io.SourceFile;

import java.util.Arrays;
import java.util.List;

/**
 * This class orchestrates all the compilation process.
 *
 * @author Hudson Schumaker
 */
public final class Maestro {

    private final List<String> args;

    public Maestro(String[] args) {
        this.args = Arrays.asList(args);
    }

    public void start() {

    }

    public SourceFile initializeO3File(String path) throws Exception {

        return null;
    }
}
