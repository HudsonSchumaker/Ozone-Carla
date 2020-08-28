package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class CloseStreamsException extends RuntimeException {

    private static final String MESSAGE = "Error during close streams.";

    public CloseStreamsException() {
        super(MESSAGE);
    }
}
