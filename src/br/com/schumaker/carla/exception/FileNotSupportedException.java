package br.com.schumaker.carla.exception;


/**
 *
 * @author Hudson Schumaker
 */
public class FileNotSupportedException extends RuntimeException {

    private static final String MESSAGE = "File not supported. Use a .o3";

    public FileNotSupportedException() {
        super(MESSAGE);
    }
}
