package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3File;
import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.o3.O3Keyword;

/**
 * Helper class
 * @author schumaker
 */
public final class LexerHelper {

    private LexerHelper() {}

    public static boolean isFunctionHeader(String data) {
        return data.startsWith(O3Keyword.FUNCTION);
    }

    public static boolean isConditionalStatement(String data) {
        return data.trim().startsWith(O3Keyword.IF);
    }

    public static boolean isLoopStatement(String data) {
        return data.contains(O3Keyword.WHILE) 
                || data.contains(O3Keyword.FOR);
    }
    
    public static boolean isVariableDeclaration(String data) {
        return data.contains(O3Keyword.VARIABLE);
    }
    
    public static boolean isAnExpression(String data) {
        return data.trim().contains(O3Keyword.OPEN_EXPRESSION)
                && data.trim().contains(O3Keyword.CLOSE_EXPRESSION);
    }

    public static boolean isReturnStatement(String data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static boolean containsFunctionMain(O3File file) {
        for (O3FileLine line : file.getLines()) {
            if (line.getData().contains("f: main()")) {
                return true;
            }
        }
        return false;
    }
}
