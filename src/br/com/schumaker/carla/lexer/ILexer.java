package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.o3.impl.O3Atom;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {

    O3Atom createProgram(O3File file);
}
