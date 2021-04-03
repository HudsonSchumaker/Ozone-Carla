package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.lexer.ILexer;
import br.com.schumaker.carla.o3.impl.App;

/**
 * Main class of O3 (Carla Compiler) Lexer.
 *
 * @author Hudson Schumaker
 */
public class Lexer implements ILexer {

    @Override
    public App createProgram(O3File file) {
        var lexerFunction = new LexerFunction();
        var functions = lexerFunction.getFunctions(file);

        return new App(file.getName(), functions);
    }
}
