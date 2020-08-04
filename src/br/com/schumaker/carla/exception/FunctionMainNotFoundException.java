package br.com.schumaker.carla.exception;

/**
 *
 * @author schumaker
 */
public class FunctionMainNotFoundException extends RuntimeException {
    
    private static final String MESSAGE = "Create a main funciton. Ex: f: main() {}"; 
    
    public FunctionMainNotFoundException() {
        super(MESSAGE);
    }   
}