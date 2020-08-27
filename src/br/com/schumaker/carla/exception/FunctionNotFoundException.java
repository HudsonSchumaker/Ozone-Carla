package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class FunctionNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Function not found.";

    public FunctionNotFoundException() {
        super(MESSAGE);
    }
}
