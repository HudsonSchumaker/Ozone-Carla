package old.br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import old.br.com.schumaker.carla.files.O3FileLine;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public class O3FunctionStatement implements IO3Statement {

    private List<O3Variable> variables;
    private List<O3FunctionCall> functionCalls;
    private List<O3FileLine> lines;
    // conditional statements
    // loops statments
}
