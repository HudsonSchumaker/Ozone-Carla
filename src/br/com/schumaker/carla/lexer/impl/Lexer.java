package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.lexer.ILexer;
import br.com.schumaker.carla.o3.impl.App;

import java.util.List;

/**
 * Main class of O3 (Carla Compiler) Lexer.
 *
 * @author Hudson Schumaker
 */
public class Lexer implements ILexer {

    @Override
    public App createProgram(List<O3File> files) {

        var lexerFunction = new LexerFunction();
        var functions = lexerFunction.getFunctions(file);

        return new App(file.getName(), functions);
    }
}
