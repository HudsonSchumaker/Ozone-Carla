package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class VariableTypeNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Variable type not found.";

    public VariableTypeNotFoundException() {
        super(MESSAGE);
    }
}
