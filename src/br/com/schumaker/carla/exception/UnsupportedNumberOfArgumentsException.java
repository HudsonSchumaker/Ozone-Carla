package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class UnsupportedNumberOfArgumentsException extends RuntimeException {
    
    private static final String MESSAGE = "Number of arguments are not correct.";
    
    public UnsupportedNumberOfArgumentsException() {
        super(MESSAGE);
    }
}
