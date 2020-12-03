package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.core.O3Keyword;
import br.com.schumaker.carla.io.FileLine;
import br.com.schumaker.carla.io.SourceFile;

/**
 * Helper class
 *
 * @author Hudson Schumaker
 */
public final class LexerHelper {

    private LexerHelper() {
    }

    public static boolean isFunctionHeader(String data) {
        return data.startsWith(O3Keyword.FUNCTION);
    }

    public static boolean isConditionalStatement(String data) {
        return data.trim().startsWith(O3Keyword.IF);
    }

    public static boolean isLoopStatement(String data) {
        return data.contains(O3Keyword.WHILE) || data.contains(O3Keyword.FOR);
    }

    public static boolean isVariableDeclaration(String data) {
        return data.contains(O3Keyword.VARIABLE);
    }

    public static boolean isAnExpression(String data) {
        return data.trim().contains(O3Keyword.OPEN_EXPRESSION)
                && data.trim().contains(O3Keyword.CLOSE_EXPRESSION);
    }

    public static boolean isReturnStatement(String data) {
        return data.trim().contains(O3Keyword.RETURN);
    }

    public static boolean containsFunctionMain(SourceFile file) {
        for (FileLine line : file.getLines()) {
            if (line.getData().contains("f: main()")) {
                return true;
            }
        }
        return false;
    }
}