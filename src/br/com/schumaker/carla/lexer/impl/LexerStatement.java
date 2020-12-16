package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerStatement;
import br.com.schumaker.carla.o3.Statement;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.List;

/**
 * This class create the O³ functions statements representations.
 *
 * @author Hudson Schumaker
 */
public class LexerStatement implements ILexerStatement {

    @Override
    public void getFunctionStatements(List<O3Function> functions) {
        for (O3Function func : functions) {
            this.getFunctionStatement(func);
        }
    }

    public void getFunctionStatement(O3Function function) {
        //TODO
    }

    @Override
    public List<O3FileLine> getLinesWithVariableDeclaration(Statement statement) {
        return null;
    }

    @Override
    public List<O3Variable> getVariables(String functionName, List<O3FileLine> lines) {
        return null;
    }
}
