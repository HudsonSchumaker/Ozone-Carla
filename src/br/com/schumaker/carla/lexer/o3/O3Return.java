package br.com.schumaker.carla.lexer.o3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public class O3Return implements IO3Variable {

    private String internalName;
    private O3VariableType type;
    private boolean returnToVariable;
    private boolean returnToFunction;
    private String variableName;
    private String functionName;
}
