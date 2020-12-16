package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.Statement;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerStatement {
    void getFunctionStatements(List<O3Function> functions);

    List<O3FileLine> getLinesWithVariableDeclaration(Statement statement);

    List<O3Variable> getVariables(String functionName, List<O3FileLine> lines);
}
