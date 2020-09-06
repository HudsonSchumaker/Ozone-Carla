package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class LoadSysCallCodesException extends RuntimeException {
    
    private static final String MESSAGE = "Error loading syscalls codes values.";
    
    public LoadSysCallCodesException() {
        super(MESSAGE);
    }
    
}
