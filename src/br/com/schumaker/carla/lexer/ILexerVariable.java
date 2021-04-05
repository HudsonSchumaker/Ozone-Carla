package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.o3.impl.O3Class;

/**
 * @author Hudson Schumaker
 */
public interface ILexerVariable {

    /**
     * This method create a list of variables of a class.
     *
     * @param o3Class O3Class, that has a source file .o3
     * @return List<O3Variable>, representation of the class global variables.
     */
    void getClassVariables(O3Class o3Class);

}
