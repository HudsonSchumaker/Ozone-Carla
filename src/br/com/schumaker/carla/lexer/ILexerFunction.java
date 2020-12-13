package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Parameter;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerFunction {

    List<O3Function> getFunctions(O3File file);

    List<O3Parameter> getParams(String functionName, O3FileLine line);

    O3Function getBody(O3FileLine headerLine, O3File file);

    List<O3FileLine> getHeaderLines(O3File file);

    boolean isMainFunction(O3FileLine headerLine);

    String getFunctionInternalName(String data);

    String getFunctionName(String data);
}
