package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.o3.impl.App;

import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public interface ILexer {

    App createProgram(List<O3File> files);
}
