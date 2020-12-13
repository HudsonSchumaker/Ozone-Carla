package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.Statement;
import br.com.schumaker.carla.o3.VariableTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public class O3Function {

    private boolean isMain;
    private boolean hasReturn;
    private String name;
    private String internalName;
    private VariableTable variableTable;
    private Statement statement;
}
