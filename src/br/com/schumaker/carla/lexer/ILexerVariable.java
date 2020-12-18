package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerVariable {

    List<O3Variable> getVariables(String functionName, List<O3FileLine> lines);

    boolean isInitialized(String data);

    String getVariableName(String data);

    String getVariableInternalName(String functionName, String data);
}
