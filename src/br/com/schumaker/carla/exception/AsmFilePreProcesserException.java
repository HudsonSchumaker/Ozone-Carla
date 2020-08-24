package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class AsmFilePreProcesserException extends RuntimeException {
    
    private static final String MESSAGE = "Pre processing error on asm file.";
    
    public AsmFilePreProcesserException() {
        super(MESSAGE);
    }
}
