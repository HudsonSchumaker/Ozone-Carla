package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class LoadMathLibException extends RuntimeException {
    
    private static final String MESSAGE = "Error on load MathLib.";
    
    public LoadMathLibException() {
        super(MESSAGE);
    }
}
