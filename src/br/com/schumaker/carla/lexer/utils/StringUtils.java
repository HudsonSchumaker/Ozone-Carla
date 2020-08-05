package br.com.schumaker.carla.lexer.utils;

/**
 *
 * @author schumaker
 */
public final class StringUtils {
    private StringUtils() {}
    
    public static boolean isBlankString(String value) {
        return value == null || value.trim().isEmpty();
    }
}