package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.o3.impl.App;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {

    App createProgram(O3File file);
}
