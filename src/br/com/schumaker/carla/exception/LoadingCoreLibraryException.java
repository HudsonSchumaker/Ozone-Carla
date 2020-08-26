package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class LoadingCoreLibraryException extends RuntimeException {
    
    private static final String MESSAGE = "Error loading core library.";
    
    public LoadingCoreLibraryException() {
        super(MESSAGE);
    }
}
