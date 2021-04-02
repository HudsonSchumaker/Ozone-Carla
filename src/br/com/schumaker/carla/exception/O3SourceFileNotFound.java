package br.com.schumaker.carla.exception;

/**
 * @author Hudson Schumaker
 */
public class O3SourceFileNotFound extends RuntimeException {

    private static final String MESSAGE = "Map operation fail.";

    public O3SourceFileNotFound() {
        super(MESSAGE);
    }
}
