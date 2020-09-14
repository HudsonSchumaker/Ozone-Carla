package old.br.com.schumaker.carla.lexer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import old.br.com.schumaker.carla.files.O3File;
import old.br.com.schumaker.carla.files.O3FileLine;
import old.br.com.schumaker.carla.lexer.o3.O3Function;
import old.br.com.schumaker.carla.lexer.o3.O3FunctionTable;
import old.br.com.schumaker.carla.lexer.o3.O3FunctionVariableTable;
import old.br.com.schumaker.carla.lexer.o3.O3Statement;
import old.br.com.schumaker.carla.lexer.o3.O3Variable;
import old.br.com.schumaker.carla.lexer.o3.O3VariableTable;
import old.br.com.schumaker.carla.o3.O3SyntaxKeyword;

/**
 * This class create the O³ functions representations.
 *
 * @author Hudson Schumaker
 */
@Data
@NoArgsConstructor
public class LexerFunction {

    private O3FunctionTable o3FunctionTable = new O3FunctionTable();

    public List<O3Function> getFunctions(O3File file) {
        var headerLines = this.getHeaderLines(file);
        var functions = new ArrayList<O3Function>();

        for (O3FileLine line : headerLines) {
            functions.add(this.setStatement(line, file));
        }

        var lexerStatement = new LexerStatement();
        lexerStatement.getFunctionStatements(functions);

        return functions;
    }

    /**
     * This method create O3Function object with a basic O3Statement and
     * O3VariableTable, in the next step when is create the O3FunctionStament
     * the O3FunctionVariableTable should be created.
     *
     * @param headerLine
     * @param file O3File, source file .o3
     * @return O3Function, representation of a function.
     */
    public O3Function setStatement(O3FileLine headerLine, O3File file) {
        var endBlock = "";
        var k = headerLine.getInternalNumber();
        var functionLines = new ArrayList<O3FileLine>();
        while (!endBlock.equals(O3SyntaxKeyword.CLOSE_STATEMENT)) {
            functionLines.add(file.getLines().get(k));
            endBlock = file.getLines().get(k).getData();
            k++;
        }

        var function = new O3Function(
                this.getFunctionName(headerLine.getData()),
                this.getFunctionInternalName(headerLine.getData()),
                this.isMainFunction(headerLine),
                this.getParams(this.getFunctionName(headerLine.getData()), headerLine),
                new O3Statement(functionLines),
                new O3VariableTable(functionLines));
        this.o3FunctionTable.add(function); // see if the reference will be update.
        return function; // debug purpose
    }

    public List<O3FileLine> getHeaderLines(O3File file) {
        var headerLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
            if (line.isFunctionHeader()) {
                headerLines.add(line);
            }
        }
        return headerLines;
    }

    public String getFunctionName(String data) {
        var name = data.substring(O3SyntaxKeyword.FUNCTION.length(), data.length()).trim();
        name = name.substring(0, name.indexOf(O3SyntaxKeyword.OPEN_EXPRESSION));
        return name;
    }

    public String getFunctionInternalName(String data) {
        return "_" + this.getFunctionName(data) + ":";
    }

    public boolean isMainFunction(O3FileLine headerLine) {
        return headerLine.getData().contains("f: main()");
    }

    public List<O3Variable> getParams(String functionName, O3FileLine line) {
        return new LexerVariable().getParameters(functionName, line);
    }

    public O3FunctionVariableTable createVariableTable(String functionName, List<O3FileLine> lines) {
        var lexerVariable = new LexerVariable();
        var variables = lexerVariable.getVariables(functionName, lines);

        Set<O3Variable> funcVars = new HashSet<>(variables);
        return new O3FunctionVariableTable(funcVars);
    }
}
