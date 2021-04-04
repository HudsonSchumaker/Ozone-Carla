package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.impl.O3Parameter;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerParameter {

    /**
     * Creates the the parameters list of a function, based on the name of the
     * function and the declared parameters. Formula: p_ + functionName + _ +
     * nameOfParam, Ex: f: print(p: text) { some code... } The internal
     * name of the "p: text" variable will be "p_main_text:"
     *
     * @param functionName name of the function
     * @param headerLine   O3Line that holds the function signature
     * @return the parameters list of the function
     */
    List<O3Parameter> getParameters(String functionName, O3FileLine headerLine);
}
