package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class LoadPrintLibException extends RuntimeException {
    
    private static final String MESSAGE = "Error on load PrintLib.";
    
    public LoadPrintLibException() {
        super(MESSAGE);
    }
}
