package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class X64RegisterNotFound extends RuntimeException {

    private static final String MESSAGE = "64 bits register not found.";

    public X64RegisterNotFound() {
        super(MESSAGE);
    }
}
