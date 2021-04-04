package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.o3.impl.O3Keyword;

/**
 * Helper class
 *
 * @author Hudson Schumaker
 */
public final class LexerHelper {

    private LexerHelper() {
    }

    public static boolean isClassHeader(String data) {
        return data.startsWith(O3Keyword.CLASS);
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

    public static boolean isConstantDeclaration(String data) {
        return data.contains(O3Keyword.CONSTANT);
    }

    public static boolean isAnExpression(String data) {
        return data.trim().contains(O3Keyword.OPEN_EXPRESSION) && data.trim().contains(O3Keyword.CLOSE_EXPRESSION);
    }

    public static boolean isReturnStatement(String data) {
        return data.trim().contains(O3Keyword.RETURN);
    }

    public static boolean containsFunctionMain(String data) {
        return data.contains("f: main(");
    }
}