package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.exception.ClassNameNotFoundException;
import br.com.schumaker.carla.io.impl.O3File;
import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerClass;
import br.com.schumaker.carla.o3.impl.O3Class;
import br.com.schumaker.carla.o3.impl.O3Keyword;

/**
 * @author Hudson Schumaker
 */
public final class LexerClass implements ILexerClass {

    @Override
    public O3Class create(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (line.isClassHeader()) {
                return new O3Class(getClassName(line.getData()), file);
            }
        }

        throw new ClassNameNotFoundException();
    }

    private String getClassName(String data) {
        var raw = data.trim();
        raw = raw.substring(O3Keyword.CLASS.length() + 1, raw.length());
        return raw.substring(0, raw.indexOf(" "));
    }
}
