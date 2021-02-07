package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerStatement;
import br.com.schumaker.carla.o3.Statement;
import br.com.schumaker.carla.o3.VariableTable;
import br.com.schumaker.carla.o3.impl.*;

import java.util.ArrayList;

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
        var statement = function.getStatement();
        var varsDeclaration = this.getLinesWithVariableDeclaration(statement);
        var variables = this.getVariables(function.getName(), varsDeclaration);
        function.getVariableTable().addVariables(variables);

        var functionCalls = this.getFunctionCalls(statement, function.getVariableTable());
        // conditional statements
        // loops statments

        var functionalStatement = new O3FunctionStatement(variables, functionCalls,
                function.getStatement().getLines());

        function.setStatement(functionalStatement);
    }

    @Override
    public List<O3FileLine> getLinesWithVariableDeclaration(Statement statement) {
        var varLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : statement.getLines()) {
            if (line.isVariableDeclaration()) {
                varLines.add(line);
            }
        }
        return varLines;
    }

    @Override
    public List<O3Variable> getVariables(String functionName, List<O3FileLine> lines) {
        return null;
    }

    @Override
    public List<O3FunctionCall> getFunctionCalls(Statement statement, VariableTable variableTable) {
        var lexerFunctionCalls = new LexerFunctionCall();
        return null;
    }
}
