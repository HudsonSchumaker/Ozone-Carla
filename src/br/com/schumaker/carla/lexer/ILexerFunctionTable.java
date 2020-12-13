package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.o3.impl.O3Function;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface ILexerFunctionTable {
    void add(O3Function function);

    List<O3Function> getAllFunctions();

    boolean functionIsDeclared(String name);

    O3Function getFunctionByName(String name);
}
