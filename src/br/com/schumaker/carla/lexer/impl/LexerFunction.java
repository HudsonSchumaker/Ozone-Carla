package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerFunction;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.o3.impl.O3Parameter;

import java.util.List;

/**
 * This class create the O3 functions representations.
 *
 * @author Hudson Schumaker
 */
public final class LexerFunction implements ILexerFunction {

    @Override
    public List<O3Function> getFunctions(O3File file) {
        return null;
    }

    @Override
    public List<O3Parameter> getParams(String functionName, O3FileLine line) {
        return null;
    }

    @Override
    public O3Function getBody(O3FileLine headerLine, O3File file) {
        return null;
    }

    @Override
    public List<O3FileLine> getHeaderLines(O3File file) {
        return null;
    }

    @Override
    public String getFunctionName(String data) {
        var name = data.substring(O3Keyword.FUNCTION.length(), data.length()).trim();
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
