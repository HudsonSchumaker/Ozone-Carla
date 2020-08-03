package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.o3.IO3Statement;
import br.com.schumaker.carla.o3.O3Function;
import br.com.schumaker.carla.o3.O3FunctionStatement;
import br.com.schumaker.carla.o3.O3Variable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schumaker
 */
public class LexerStatement {
    
    public List<O3Function>getStatement(List<O3Function> function) {
        return null; // TODO
    }

    public O3Function getStatement(O3Function function) {
        var statement = function.getStatement();
        var linesVarDeclare = this.getLinesWithVariableDeclaration(statement);
        
        var lexerVariable = this.getVariables(function.getName(), linesVarDeclare);
        

        // conditional statements
        // loops statments
        
        return function;
    }
    
    public List<O3FileLine> getLinesWithVariableDeclaration(IO3Statement statement) {
        var varLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : statement.getLines()) {
            if (line.isVariableDeclaration()) {
                varLines.add(line);
            }
        }
        return varLines;
    } 
    
    List<O3Variable> getVariables(String functionName, List<O3FileLine> lines) {
        var lexerVariable = new LexerVariable();
        return lexerVariable.getVariables(functionName, lines);
    }
}
