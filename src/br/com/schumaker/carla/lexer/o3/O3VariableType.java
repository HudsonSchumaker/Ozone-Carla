package br.com.schumaker.carla.lexer.o3;

import br.com.schumaker.carla.o3.O3CoreType;

/**
 * This enumerator defines the variables types of O³ pl.
 *
 * @author schumaker
 */
public enum O3VariableType {
    BYTE("byte", "0", O3CoreType.BYTE.getSize()),
    BOOL("bool", "false", O3CoreType.BOOL.getSize()),
    CHAR("char", "", O3CoreType.CHAR.getSize()),
    STRING("string", "", O3CoreType.STRING.getSize()),
    INT("int", "0", O3CoreType.INT.getSize()),
    LONG("long", "0L", O3CoreType.LONG.getSize()),
    FLOAT("float", "0.0f", O3CoreType.FLOAT.getSize()),
    DOUBLE("double", "0.0d", O3CoreType.DOUBLE.getSize()),
    PARAM("param", "?", O3CoreType.PARAM.getSize());

    private final String name;
    private final String defaultValue;
    private final int size; // size in bytes

    private O3VariableType(String name, String defaultValue, int size) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.size = size;
    }

    public static String getDefaultValueByName(String name) {
        for (O3VariableType vt : O3VariableType.values()) {
            if (vt.name().equals(name)) {
                return vt.defaultValue;
            }
        }
        return null;
    }
    
    public static int getSizeByName(String name) {
        for (O3VariableType vt : O3VariableType.values()) {
            if (vt.name().equals(name)) {
                return vt.size;
            }
        }
        return 0;
    }
    
    public String getName() {
        return name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public int getSize() {
        return size;
    }
}
