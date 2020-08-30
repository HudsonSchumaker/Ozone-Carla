package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class ReturnTypeNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Error when try to resolve return value/type";

    public ReturnTypeNotFoundException() {
        super(MESSAGE);
    }

}
