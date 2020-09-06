package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class VariableNotDeclaredException extends RuntimeException {

    private static final String MESSAGE = "Variable not declared.";

    public VariableNotDeclaredException() {
        super(MESSAGE);
    }
}
