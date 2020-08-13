package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.lexer.o3.IO3Variable;
import java.util.List;

/**
 *
 * @author schumaker
 */
public interface IAtomVariableTable {
    void add(IO3Variable o3Var);
    List<IO3Variable> getVariables();
    boolean varibleIsDeclared(String name);
}
