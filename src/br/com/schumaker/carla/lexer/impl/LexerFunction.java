package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerFunction;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.o3.impl.O3Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create the O3 functions representations.
 *
 * @author Hudson Schumaker
 */
public final class LexerFunction implements ILexerFunction {

    private LexerFunctionTable functionTable = new LexerFunctionTable();

    @Override
    public List<O3Function> getFunctions(O3File file) {
        var headerLines = this.getHeaderLines(file);
        var functions = new ArrayList<O3Function>();

        for (O3FileLine line : headerLines) {
            functions.add(this.getBody(line, file));
        }

        return null;
    }

    @Override
    public List<O3Parameter> getParams(String functionName, O3FileLine line) {
        return null;
    }

    @Override
    public O3Function getBody(O3FileLine headerLine, O3File file) {
        var endBlock = "";
        var k = headerLine.getInternalNumber();
        var functionLines = new ArrayList<O3FileLine>();
        while (!endBlock.equals(O3Keyword.CLOSE_STATEMENT)) {
            functionLines.add(file.getLines().get(k));
            endBlock = file.getLines().get(k).getData();
            k++;
        }


        return null;
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
    public String getFunctionName(String data) {
        var name = data.substring(O3Keyword.FUNCTION.length()).trim();
        return name.substring(0, name.indexOf(O3Keyword.OPEN_EXPRESSION)).trim();
    }

    @Override
    public String getFunctionInternalName(String data) {
        return "_" + this.getFunctionName(data);
    }

    @Override
    public boolean isMainFunction(O3FileLine headerLine) {
        return headerLine.getData().contains("f: main()");
    }
}
