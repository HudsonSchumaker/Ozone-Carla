package br.com.schumaker.carla.lexer.o3;

import java.util.List;
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
public class O3FunctionCall {

    private String functionName;
    private List<O3Argument> arguments;
    private boolean hasReturn;
    private O3Return o3return;
}
