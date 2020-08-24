package br.com.schumaker.carla.exception;

/**
 *
 * @author Hudson Schumaker
 */
public class CopyNASMZipFileException extends RuntimeException {
    
    private static final String MESSAGE = "Error during copy NASM zip file.";
    
    public CopyNASMZipFileException() {
        super(MESSAGE);
    }
}