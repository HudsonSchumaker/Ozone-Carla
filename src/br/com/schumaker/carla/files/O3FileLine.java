package br.com.schumaker.carla.files;

import lombok.Data;

/**
 * This class holds O3 line from source file.
 * @author schumaker
 */

@Data
public class O3FileLine {
    
    private String data;
    private boolean functionHeader;
    private boolean conditionalStatement;
    private boolean loopStatement;
    private boolean returnStatement;
    private Integer originalNumber;
    private Integer internalNumber;
    
    public O3FileLine(String data, Integer originalNumber) {
        this.data = data;
        this.originalNumber = originalNumber;
    }
}