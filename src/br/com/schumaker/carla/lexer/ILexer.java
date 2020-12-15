package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.o3.impl.Tabula;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {

    Tabula createProgram(O3File file);
}
