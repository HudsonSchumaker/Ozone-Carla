package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.SourceFile;
import br.com.schumaker.carla.o3.Atom;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {

    Atom createProgram(SourceFile file);
}
