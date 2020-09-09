package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class X128RegisterNotFound extends RuntimeException {

    private static final String MESSAGE = "128 bits register not found.";

    public X128RegisterNotFound() {
        super(MESSAGE);
    }

    public X128RegisterNotFound(String name) {
        super(MESSAGE + "" + name + ".");
    }
}
