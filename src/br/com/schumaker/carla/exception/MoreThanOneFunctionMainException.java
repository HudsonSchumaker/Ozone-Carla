package br.com.schumaker.carla.exception;

public class MoreThanOneFunctionMainException extends RuntimeException {

    private static final String MESSAGE = "More than one function main found.";

    public MoreThanOneFunctionMainException() {
        super(MESSAGE);
    }
}
