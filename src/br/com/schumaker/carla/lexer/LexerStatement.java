package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.lexer.o3.IO3Statement;
import br.com.schumaker.carla.lexer.o3.O3Function;
import br.com.schumaker.carla.lexer.o3.O3FunctionStatement;
import br.com.schumaker.carla.lexer.o3.O3Variable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class create the O³ functions statements representations.
 * @author schumaker
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
        var o3Varibales = this.getVariables(function.getName(), varsDeclaration);
        
        // function calls
        // conditional statements
        // loops statments
        
        var functionalStatement = new O3FunctionStatement(o3Varibales, varsDeclaration);
        function.setStatement(functionalStatement);       
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
