package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class AsmFilePreProcessorException extends RuntimeException {
    
    private static final String MESSAGE = "Pre processing error on asm file.";
    
    public AsmFilePreProcessorException() {
        super(MESSAGE);
    }
}
