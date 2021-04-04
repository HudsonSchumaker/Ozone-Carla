package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerVariable {

    /**
     * This method create a list of variables of a class.
     *
     * @param file O3File, source file .o3
     * @return List<O3Variable>, representation of the class global variables.
     */
    List<O3Variable> getClassVariables(O3File file);

}
