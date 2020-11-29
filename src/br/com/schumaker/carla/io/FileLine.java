package br.com.schumaker.carla.io;

import lombok.Data;

@Data
public class FileLine {

    private String data;
    private boolean functionHeader;
    private boolean conditionalStatement;
    private boolean loopStatement;
    private boolean variableDeclaration;
    private boolean returnStatement;
    private boolean functionCall;
    private Integer originalNumber;
    private Integer internalNumber;

    public FileLine(String data, Integer originalNumber) {
        this.data = data;
        this.originalNumber = originalNumber;
    }
}