package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.o3.impl.O3Class;

/**
 * @author Hudson Schumaker
 */
public interface ILexerClass {

    O3Class create(O3File file);
}
