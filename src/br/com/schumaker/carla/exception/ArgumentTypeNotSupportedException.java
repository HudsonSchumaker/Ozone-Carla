package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class ArgumentTypeNotSupportedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String MESSAGE = "Wrong argument type. Please read the documentation.";

    public ArgumentTypeNotSupportedException() {
        super(MESSAGE);
    }
}
