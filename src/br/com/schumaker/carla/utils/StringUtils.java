package br.com.schumaker.carla.utils;

/**
 *
 * @author Hudson Schumaker
 */
public class StringUtils {

    private StringUtils() {}

    public static boolean isBlankString(String value) {
        return value == null || value.trim().isEmpty();
    }
}
