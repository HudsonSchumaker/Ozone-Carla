package br.com.schumaker.carla.exception;

import br.com.schumaker.carla.files.O3File;

/**
 *
 * @author Hudson Schumaker
 */
public class FileNotSupportedException extends RuntimeException {

    private static final String MESSAGE = "File not supported. Use a ." + O3File.EXT;

    public FileNotSupportedException() {
        super(MESSAGE);
    }
}
