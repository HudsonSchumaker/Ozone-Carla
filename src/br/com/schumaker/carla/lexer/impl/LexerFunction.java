package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.lexer.ILexerFunction;
import br.com.schumaker.carla.o3.impl.O3Function;
import br.com.schumaker.carla.o3.impl.O3Keyword;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public final class LexerFunction implements ILexerFunction {

    @Override
    public List<O3Function> getFunctions(O3File file) {
        return null;
    }

    @Override
    public String getFunctionName(String data) {
        var name = data.substring(O3Keyword.FUNCTION.length(), data.length()).trim();
        return name.substring(0, name.indexOf(O3Keyword.OPEN_EXPRESSION));
    }
}
