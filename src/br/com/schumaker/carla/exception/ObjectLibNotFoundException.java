package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class ObjectLibNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Object library not found.";

    public ObjectLibNotFoundException() {
        super(MESSAGE);
    }

    public ObjectLibNotFoundException(String object) {
        super(MESSAGE + " " + object + ".");
    }
}
