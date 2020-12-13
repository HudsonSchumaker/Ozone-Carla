package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.impl.O3Parameter;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerParameter {
    List<O3Parameter> getParameters(String functionName, O3FileLine headerLine);
}
