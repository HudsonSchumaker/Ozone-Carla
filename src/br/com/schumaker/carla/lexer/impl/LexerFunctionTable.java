package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.lexer.ILexerFunctionTable;
import br.com.schumaker.carla.o3.impl.O3Function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This holds the declared O3functions inside an atom.
 *
 * @author Hudson Schumaker
 */
public class LexerFunctionTable implements ILexerFunctionTable {

    private Set<O3Function> functions = new HashSet<>();

    @Override
    public void add(O3Function function) {
        functions.add(function);
    }

    @Override
    public List<O3Function> getAllFunctions() {
        return new ArrayList<>(functions);
    }

    @Override
    public boolean functionIsDeclared(String name) {
        //Predicate<O3Function> pVar = v -> v.getName().equals(name);
        return functions.stream()
                .parallel()
                .anyMatch(f -> f.getName().equals(name));
    }

    @Override
    public O3Function getFunctionByName(String name) {
        return functions.stream()
                .parallel()
                .filter(f -> f.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
