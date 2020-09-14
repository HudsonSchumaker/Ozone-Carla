package old.br.com.schumaker.carla.lexer;

import java.util.List;
import old.br.com.schumaker.carla.lexer.o3.IO3Variable;

/**
 *
 * @author Hudson Schumaker
 */
public interface IAtomVariableTable {
    void add(IO3Variable o3Var);
    List<IO3Variable> getVariables();
    boolean varibleIsDeclared(String name);
}
