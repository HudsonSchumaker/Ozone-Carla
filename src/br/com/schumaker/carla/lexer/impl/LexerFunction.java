package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerFunction;
import br.com.schumaker.carla.lexer.ILexerFunctionTable;
import br.com.schumaker.carla.o3.VariableTable;
import br.com.schumaker.carla.o3.impl.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create the O3 functions representations.
 *
 * @author Hudson Schumaker
 */
@Getter
public final class LexerFunction implements ILexerFunction {

    private LexerFunctionTable functionTable = new LexerFunctionTable();

    @Override
    public List<O3Function> getFunctions(O3File file) {
        var headerLines = this.getHeaderLines(file);
        for (O3FileLine line : headerLines) {
            functionTable.add(this.getBody(line, file));
        }

        // TODO create O3FunctionStatement and update O3FunctionVariableTable
        return functionTable.getAllFunctions();
    }

    /**
     * Return a list with the parameters of a function.
     *
     * @param functionName Declared function name.
     * @param headLine     Signature of the function.
     * @return List of parameter of the function.
     */
    @Override
    public List<O3Parameter> getParams(String functionName, O3FileLine headLine) {
        return new LexerParameter().getParameters(functionName, headLine);
    }

    /**
     * This method create O3Function object with a basic O3Statement and
     * O3FunctionVariableTable incomplete (only parameter variables), in the next step when
     * is create the O3FunctionStatement and the O3FunctionVariableTable should be update.
     *
     * @param headerLine Signature of the function.
     * @param file       O3File, source file .o3
     * @return O3Function, representation of a function.
     */
    @Override
    public O3Function getBody(O3FileLine headerLine, O3File file) {
        var endBlock = "";
        var k = headerLine.getInternalNumber();
        var body = new ArrayList<O3FileLine>();
        while (!endBlock.equals(O3Keyword.CLOSE_STATEMENT)) {
            body.add(file.getLines().get(k));
            endBlock = file.getLines().get(k).getData();
            k++;
        }

        var functionName = this.getFunctionName(headerLine);
        var params = this.getParams(functionName, headerLine);
        var function = new O3Function(this.isMainFunction(headerLine),
                hasReturn(body),
                functionName,
                this.getFunctionInternalName(headerLine),
                new O3FunctionVariableTable(params),
                new O3Statement(body));

        this.functionTable.add(function);
        return function;
    }

    @Override
    public List<O3FileLine> getHeaderLines(O3File file) {
        var headerLines = new ArrayList<O3FileLine>();
        for (O3FileLine line : file.getLines()) {
            if (line.isFunctionHeader()) {
                headerLines.add(line);
            }
        }
        return headerLines;
    }

    @Override
    public VariableTable createVariableTable(String functionName, List<O3FileLine> lines) {
        return null;
    }

    @Override
    public String getFunctionName(O3FileLine headerLine) {
        var name = headerLine.getData().substring(O3Keyword.FUNCTION.length()).trim();
        return name.substring(0, name.indexOf(O3Keyword.OPEN_EXPRESSION)).trim();
    }

    @Override
    public String getFunctionInternalName(O3FileLine headerLine) {
        return "_" + this.getFunctionName(headerLine);
    }

    @Override
    public boolean isMainFunction(O3FileLine headerLine) {
        return headerLine.getData().contains("f: main()");
    }

    @Override
    public LexerFunctionTable getFunctionTable() {
        return functionTable;
    }

    public boolean hasReturn(List<O3FileLine> body) {
        return body.stream().filter(O3FileLine::isReturnStatement).findAny().isPresent();
    }
}
