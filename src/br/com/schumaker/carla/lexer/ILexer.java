package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.o3.impl.App;
import br.com.schumaker.carla.o3.impl.O3Class;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexer {

    /**
     * Create the O3 program.
     */
    App createProgram(List<O3File> files);

    /**
     * Create the O3 classes.
     */
    O3Class createClass(O3File file);

}