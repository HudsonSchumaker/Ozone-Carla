package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.lexer.ILexerVariable;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.List;

/**
 * This class create the O³ variables representations.
 *
 * @author Hudson Schumaker
 */
public final class LexerVariable implements ILexerVariable {

    private final LexerMemoryType lexerMemorySpaceType = new LexerMemoryType();


    @Override
    public List<O3Variable> getClassVariables(O3File file) {


        return null;
    }
}


