package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class LoadStringLibException extends RuntimeException {
    
    private static final String MESSAGE = "Error on load StringLib.";
    
    public LoadStringLibException() {
        super(MESSAGE);
    }
}
