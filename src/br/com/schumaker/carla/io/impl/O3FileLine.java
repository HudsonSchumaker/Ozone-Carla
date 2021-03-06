package br.com.schumaker.carla.io.impl;

import lombok.Data;

/**
 * This class holds O3 line from source file.
 *
 * @author Hudson Schumaker
 */
@Data
public final class O3FileLine {

    private String data;
    private boolean classHeader;
    private boolean functionHeader;
    private boolean conditionalStatement;
    private boolean loopStatement;
    private boolean variableDeclaration;
    private boolean constantDeclaration;
    private boolean returnStatement;
    private boolean functionCall;
    private Integer originalNumber;
    private Integer internalNumber;

    public O3FileLine(String data, Integer originalNumber) {
        this.data = data;
        this.originalNumber = originalNumber;
    }
}