package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.lexer.ILexer;
import br.com.schumaker.carla.lexer.ILexerClass;
import br.com.schumaker.carla.lexer.ILexerVariable;
import br.com.schumaker.carla.o3.impl.App;
import br.com.schumaker.carla.o3.impl.O3Class;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class of O3 (Carla Compiler) Lexer.
 *
 * @author Hudson Schumaker
 */
public final class Lexer implements ILexer {

    private final ILexerClass lexerClass = new LexerClass();
    private final ILexerVariable lexerVariable = new LexerVariable();

    @Override
    public App createProgram(List<O3File> files) {

        var classes = new ArrayList<O3Class>();
        for (O3File file : files) {
            classes.add(createClass(file));
        }


        return new App("", null, null);
    }

    @Override
    public O3Class createClass(O3File file) {
        return lexerClass.create(file);
    }

    public List<O3Variable> createClassVariables() {

        return null;
    }

    public List<O3Function> createClassFunctions() {

        return null;
    }
}
