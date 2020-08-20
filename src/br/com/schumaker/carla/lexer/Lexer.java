package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3File;
import br.com.schumaker.carla.lexer.o3.O3Atom;

/**
 * Main class of O3 (Carla Compiler) Lexer.
 * @author schumaker
 */
public class Lexer {
    
    public O3Atom createProgram(O3File o3File) {
        var lexerFunction = new LexerFunction();
        var functions = lexerFunction.getFunctions(o3File);
        return new O3Atom(o3File.getName(),lexerFunction.getO3FunctionTable() , functions);
    } 
}
