package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class VariableDefaultValueNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Variable default value not found";

    public VariableDefaultValueNotFoundException() {
        super(MESSAGE);
    }
}
