package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class MapperOperationException extends RuntimeException {

    private static final String MESSAGE = "Map operation fail.";

    public MapperOperationException() {
        super(MESSAGE);
    }

}
