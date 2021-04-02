package br.com.schumaker.carla.exception;

/**
 * @author Hudson Schumaker
 */
public class O3SourceFileNotFoundException extends RuntimeException {

    private static final String MESSAGE = "There is no o3 file in the source folder.";

    public O3SourceFileNotFoundException() {
        super(MESSAGE);
    }
}
