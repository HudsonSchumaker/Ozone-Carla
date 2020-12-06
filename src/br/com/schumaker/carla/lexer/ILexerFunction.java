package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.o3.impl.O3Function;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerFunction {

    List<O3Function> getFunctions(O3File file);

    String getFunctionName(String data);

    boolean isMainFunction(O3FileLine headerLine);
}
