package old.br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the O³ program.
 *
 * @author Hudson Schumaker
 */
@Data
@AllArgsConstructor
public class O3Atom {

    private String name;
    private O3AtomVariableTable varibleTable;
    private O3FunctionTable functionTable;
    private List<O3Function> functions;
}
