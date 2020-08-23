package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class WriteAsmFileException  extends RuntimeException {
    private static final String MESSAGE = "Write Asm file error.";
    
    public WriteAsmFileException() {
        super(MESSAGE);
    }
}
