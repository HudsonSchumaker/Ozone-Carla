package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class WriteMakefileException extends RuntimeException {

    private static final String MESSAGE = "Write Makefile error.";

    public WriteMakefileException() {
        super(MESSAGE);
    }
}
