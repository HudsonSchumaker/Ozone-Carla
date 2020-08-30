package br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@AllArgsConstructor
public class O3FunctionCall {

    private String functionName;
    private List<O3Argument> arguments;
    private boolean hasReturn;
    private O3Return o3return;

    @Override
    public String toString() {
        return "{\n"
                + "\tFunctionName  : " + functionName + ",\n"
                + "\tArguments : " + arguments + "\n"
                + "}";
    }
}
