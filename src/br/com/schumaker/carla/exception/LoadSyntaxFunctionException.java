package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class LoadSyntaxFunctionException extends RuntimeException {

    private static final String MESSAGE = "Error on load O3SyntaxFunctionTable.";

    public LoadSyntaxFunctionException() {
        super(MESSAGE);
    }
}
