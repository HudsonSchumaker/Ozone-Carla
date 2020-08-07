package br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author schumaker
 */

@Data
@AllArgsConstructor
public class O3FunctionCall {
    private String functionName;
    private List<O3Argument> arguments; 
}