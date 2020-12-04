package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.o3.Atom;

import java.io.File;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {

    Atom createProgram(File file);
}
