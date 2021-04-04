package br.com.schumaker.carla.exception;

/**
 * @author Hudson Schumaker
 */
public class ClassNameNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Class name missing.";

    public ClassNameNotFoundException() {
        super(MESSAGE);
    }
}
