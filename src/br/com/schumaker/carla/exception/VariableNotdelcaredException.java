package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class VariableNotdelcaredException extends RuntimeException {

    private static final String MESSAGE = "Variable not declared.";

    public VariableNotdelcaredException() {
        super(MESSAGE);
    }
}
