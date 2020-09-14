package old.br.com.schumaker.carla.lexer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import old.br.com.schumaker.carla.files.O3FileLine;
import old.br.com.schumaker.carla.lexer.o3.IO3Statement;
import old.br.com.schumaker.carla.lexer.o3.IO3VariableTable;
import old.br.com.schumaker.carla.lexer.o3.O3Function;
import old.br.com.schumaker.carla.lexer.o3.O3FunctionCall;
import old.br.com.schumaker.carla.lexer.o3.O3FunctionStatement;
import old.br.com.schumaker.carla.lexer.o3.O3FunctionVariableTable;
import old.br.com.schumaker.carla.lexer.o3.O3Variable;

/**
 * This class create the O³ functions statements representations.
 *
 * @author Hudson Schumaker
 */
public class LexerStatement {

    public void getFunctionStatements(List<O3Function> functions) {
        for (O3Function func : functions) {
            this.getFunctionStatement(func);
        }
        //return functions;
    }

    public void getFunctionStatement(O3Function function) {
        var statement = function.getStatement();
        var varsDeclaration = this.getLinesWithVariableDeclaration(statement);
        var variables = this.getVariables(function.getName(), varsDeclaration);

        function.setVariableTable(this.createVariableTable(variables));

        var functionCalls = this.getFunctionCalls(statement, function.getVariableTable());
        // conditional statements
        // loops statments

        var functionalStatement
                = new O3FunctionStatement(variables, functionCalls,
                        function.getStatement().getLines());

        function.setStatement(functionalStatement);
    }

    /**
     * Get lines with variable declaration based on the tag syntax.
     *
     * @param statement
     * @return
     */
    public List<O3FileLine> getLinesWithVariableDeclaration(IO3Statement statement) {
        var varLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : statement.getLines()) {
            if (line.isVariableDeclaration()) {
                varLines.add(line);
            }
        }
        return varLines;
    }

    /**
     * Creates variables with all params.
     *
     * @param functionName
     * @param lines
     * @return
     */
    public List<O3Variable> getVariables(String functionName, List<O3FileLine> lines) {
        var lexerVariable = new LexerVariable();
        return lexerVariable.getVariables(functionName, lines);
    }

    public List<O3FunctionCall> getFunctionCalls(IO3Statement statement, IO3VariableTable variableTable) {
        var lexerFunctionCalls = new LexerFunctionCall();
        return lexerFunctionCalls.getFunctionCalls(statement, (O3FunctionVariableTable) variableTable);
    }

    /**
     * Creates a table variable of the function.
     * @param variables
     * @return O3FunctionVariabletable
     */
    public O3FunctionVariableTable createVariableTable(List<O3Variable> variables) {
        Set<O3Variable> funcVars = new HashSet<>(variables);
        return new O3FunctionVariableTable(funcVars);
    }
}
