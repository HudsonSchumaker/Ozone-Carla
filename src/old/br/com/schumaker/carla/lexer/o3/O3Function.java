package old.br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * This class represents the functions of O³ pl. Ex: f: main() { ; some code
 * here... }
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public class O3Function {

    private String name;
    private String internalName;
    private boolean isMain;
    private List<O3Variable> params;
    private IO3Statement statement;
    private IO3VariableTable variableTable;
}
