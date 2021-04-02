package br.com.schumaker.carla.exception;

/**
 * @author Hudson Schumaker
 */
public class O3SourceFileNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Map operation fail.";

    public O3SourceFileNotFoundException() {
        super(MESSAGE);
    }
}
